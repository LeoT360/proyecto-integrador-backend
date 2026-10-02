package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateUsersRequestDto; import co.edu.cesde.ga.application.dto.response.CreateUsersResponseDto; import co.edu.cesde.ga.application.service.UsersService; import co.edu.cesde.ga.domain.model.Users; import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/users") public class UsersController {
 private final UsersService service;

 public UsersController(UsersService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateUsersResponseDto> create(@Valid @RequestBody CreateUsersRequestDto d) {
  var x = service.create(new Users(d.username(), d.email(), d.passwordHash(), d.status()));
  return ResponseEntity.created(URI.create("/users/" + x.getUserId())).body(CreateUsersResponseDto.fromUsers(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateUsersResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateUsersResponseDto::fromUsers).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateUsersResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateUsersResponseDto.fromUsers(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateUsersResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateUsersRequestDto d) {
  var x = new Users(d.username(), d.email(), d.passwordHash(), d.status());
  x.setUserId(id);
  service.update(x);
  return ResponseEntity.ok(CreateUsersResponseDto.fromUsers(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}
