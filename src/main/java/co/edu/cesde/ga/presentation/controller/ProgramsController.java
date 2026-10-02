package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreateProgramsRequestDto; import co.edu.cesde.ga.application.dto.response.CreateProgramsResponseDto; import co.edu.cesde.ga.application.service.ProgramsService; import co.edu.cesde.ga.domain.model.Programs; import jakarta.validation.Valid;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/programs") public class ProgramsController {
 private final ProgramsService service;

 public ProgramsController(ProgramsService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreateProgramsResponseDto> create(@Valid @RequestBody CreateProgramsRequestDto d) {
  var x = service.create(new Programs(d.code(), d.name()));
  return ResponseEntity.created(URI.create("/programs/" + x.getProgramId())).body(CreateProgramsResponseDto.fromPrograms(x));
 }

 @GetMapping
 public ResponseEntity<List<CreateProgramsResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreateProgramsResponseDto::fromPrograms).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreateProgramsResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreateProgramsResponseDto.fromPrograms(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreateProgramsResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateProgramsRequestDto d) {
  var x = new Programs(d.code(), d.name());
  x.setProgramId(id);
  service.update(x);
  return ResponseEntity.ok(CreateProgramsResponseDto.fromPrograms(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}
