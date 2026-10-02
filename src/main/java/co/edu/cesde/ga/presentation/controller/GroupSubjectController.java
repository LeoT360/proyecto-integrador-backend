package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateGroupSubjectRequestDto; import co.edu.cesde.ga.application.dto.response.CreateGroupSubjectResponseDto; import co.edu.cesde.ga.application.service.GroupSubjectService; import co.edu.cesde.ga.domain.model.GroupSubject; import jakarta.validation.Valid;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/group-subjects") public class GroupSubjectController {
 private final GroupSubjectService service;

 public GroupSubjectController(GroupSubjectService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateGroupSubjectResponseDto> create(@Valid @RequestBody CreateGroupSubjectRequestDto d) {
  var x = service.create(new GroupSubject(d.groupId(), d.subjectId(), d.teacherId()));
  return ResponseEntity.created(URI.create("/group-subjects/" + x.getGroupSubjectId())).body(CreateGroupSubjectResponseDto.fromGroupSubject(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateGroupSubjectResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateGroupSubjectResponseDto::fromGroupSubject).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateGroupSubjectResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateGroupSubjectResponseDto.fromGroupSubject(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateGroupSubjectResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateGroupSubjectRequestDto d) {
  var x = new GroupSubject(d.groupId(), d.subjectId(), d.teacherId());
  x.setGroupSubjectId(id);
  service.update(x);
  return ResponseEntity.ok(CreateGroupSubjectResponseDto.fromGroupSubject(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}