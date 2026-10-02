package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateGroupRequestDto; import co.edu.cesde.ga.application.dto.response.CreateGroupResponseDto; import co.edu.cesde.ga.application.service.GroupService; import co.edu.cesde.ga.domain.model.Group; import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/groups") public class GroupController {
 private final GroupService service;

 public GroupController(GroupService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateGroupResponseDto> create(@Valid @RequestBody CreateGroupRequestDto d) {
  var x = service.create(new Group(d.code(), d.programId(), d.periodId(), d.shift()));
  return ResponseEntity.created(URI.create("/groups/" + x.getGroupId())).body(CreateGroupResponseDto.fromGroup(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateGroupResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateGroupResponseDto::fromGroup).toList());
 }

 @GetMapping("/{code}")
 public ResponseEntity<CreateGroupResponseDto> one(@PathVariable @NotBlank String code) {
  return ResponseEntity.ok(CreateGroupResponseDto.fromGroup(service.findByCode(code)));
 }

 @PutMapping("/{code}")
 public ResponseEntity<CreateGroupResponseDto> update(@PathVariable @NotBlank String code, @Valid @RequestBody CreateGroupRequestDto d) {
  var x = new Group(code, d.programId(), d.periodId(), d.shift());
  service.update(x);
  return ResponseEntity.ok(CreateGroupResponseDto.fromGroup(service.findByCode(code)));
 }

 @DeleteMapping("/{code}")
 public ResponseEntity<Void> delete(@PathVariable @NotBlank String code) {
  service.delete(code);
  return ResponseEntity.noContent().build();
 }
}