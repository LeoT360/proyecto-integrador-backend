package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateGradesRequestDto; import co.edu.cesde.ga.application.dto.response.CreateGradesResponseDto; import co.edu.cesde.ga.application.service.GradesService; import co.edu.cesde.ga.domain.model.Grades; import jakarta.validation.Valid;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/grades") public class GradesController {
 private final GradesService service;

 public GradesController(GradesService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateGradesResponseDto> create(@Valid @RequestBody CreateGradesRequestDto d) {
  var x = service.create(new Grades(d.groupSubjectId(), d.studentId(), d.finalScore(), d.observation()));
  return ResponseEntity.created(URI.create("/grades/" + x.getGradeId())).body(CreateGradesResponseDto.fromGrades(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateGradesResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateGradesResponseDto::fromGrades).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateGradesResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateGradesResponseDto.fromGrades(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateGradesResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateGradesRequestDto d) {
  var x = new Grades(d.groupSubjectId(), d.studentId(), d.finalScore(), d.observation());
  x.setGradeId(id);
  service.update(x);
  return ResponseEntity.ok(CreateGradesResponseDto.fromGrades(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}