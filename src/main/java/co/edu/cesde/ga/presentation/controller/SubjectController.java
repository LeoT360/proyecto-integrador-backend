package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateSubjectRequestDto; import co.edu.cesde.ga.application.dto.response.CreateSubjectResponseDto; import co.edu.cesde.ga.application.service.SubjectService; import co.edu.cesde.ga.domain.model.Subject; import jakarta.validation.Valid;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/subjects") public class SubjectController {
 private final SubjectService service;

 public SubjectController(SubjectService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateSubjectResponseDto> create(@Valid @RequestBody CreateSubjectRequestDto d) {
  var x = service.create(new Subject(d.code(), d.name(), d.credits(), d.programId()));
  return ResponseEntity.created(URI.create("/subjects/" + x.getSubjectId())).body(CreateSubjectResponseDto.fromSubject(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateSubjectResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateSubjectResponseDto::fromSubject).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateSubjectResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateSubjectResponseDto.fromSubject(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateSubjectResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateSubjectRequestDto d) {
  var x = new Subject(d.code(), d.name(), d.credits(), d.programId());
  x.setSubjectId(id);
  service.update(x);
  return ResponseEntity.ok(CreateSubjectResponseDto.fromSubject(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}
