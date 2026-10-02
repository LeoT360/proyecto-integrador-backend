package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateUserRolesRequestDto; import co.edu.cesde.ga.application.dto.response.CreateUserRolesResponseDto; import co.edu.cesde.ga.application.service.UserRolesService; import co.edu.cesde.ga.domain.model.UserRoles; import jakarta.validation.Valid;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/user-roles") public class UserRolesController {
 private final UserRolesService service;

 public UserRolesController(UserRolesService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateUserRolesResponseDto> create(@Valid @RequestBody CreateUserRolesRequestDto d) {
  var x = service.create(new UserRoles(d.userId(), d.rolesId()));
  return ResponseEntity.created(URI.create("/user-roles/" + x.getUserRoleId())).body(CreateUserRolesResponseDto.fromUserRoles(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateUserRolesResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateUserRolesResponseDto::fromUserRoles).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateUserRolesResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateUserRolesResponseDto.fromUserRoles(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateUserRolesResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateUserRolesRequestDto d) {
  var x = new UserRoles(d.userId(), d.rolesId());
  x.setUserRoleId(id);
  service.update(x);
  return ResponseEntity.ok(CreateUserRolesResponseDto.fromUserRoles(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}
