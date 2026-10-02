package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateRolesRequestDto; import co.edu.cesde.ga.application.dto.response.CreateRolesResponseDto; import co.edu.cesde.ga.application.service.RolesService; import co.edu.cesde.ga.domain.model.Roles; import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/roles") public class RolesController {
 private final RolesService service;

 public RolesController(RolesService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateRolesResponseDto> create(@Valid @RequestBody CreateRolesRequestDto d) {
  var x = service.create(new Roles(d.name(), d.description()));
  return ResponseEntity.created(URI.create("/roles/" + x.getRolesId())).body(CreateRolesResponseDto.fromRoles(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateRolesResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateRolesResponseDto::fromRoles).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateRolesResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateRolesResponseDto.fromRoles(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateRolesResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateRolesRequestDto d) {
  var x = new Roles(d.name(), d.description());
  x.setRolesId(id);
  service.update(x);
  return ResponseEntity.ok(CreateRolesResponseDto.fromRoles(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}
