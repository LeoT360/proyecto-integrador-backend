package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateTeacherRequestDto; import co.edu.cesde.ga.application.dto.response.CreateTeacherResponseDto; import co.edu.cesde.ga.application.service.TeacherService; import co.edu.cesde.ga.domain.model.Teacher; import jakarta.validation.Valid;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/teachers") public class TeacherController {
 private final TeacherService service;

 public TeacherController(TeacherService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateTeacherResponseDto> create(@Valid @RequestBody CreateTeacherRequestDto d) {
  var x = service.create(new Teacher(d.userId(), d.code(), d.documentType(), d.documentNumber(), d.firstName(), d.lastName(), d.status()));
  return ResponseEntity.created(URI.create("/teachers/" + x.getTeacherId())).body(CreateTeacherResponseDto.fromTeacher(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateTeacherResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateTeacherResponseDto::fromTeacher).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateTeacherResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateTeacherResponseDto.fromTeacher(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateTeacherResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateTeacherRequestDto d) {
  var x = new Teacher(d.userId(), d.code(), d.documentType(), d.documentNumber(), d.firstName(), d.lastName(), d.status());
  x.setTeacherId(id);
  service.update(x);
  return ResponseEntity.ok(CreateTeacherResponseDto.fromTeacher(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}
