package co.edu.cesde.ga.presentation.controller;
import co.edu.cesde.ga.application.dto.request.CreatePeriodRequestDto; import co.edu.cesde.ga.application.dto.response.CreatePeriodResponseDto; import co.edu.cesde.ga.application.service.PeriodService; import co.edu.cesde.ga.domain.model.Period; import jakarta.validation.Valid;
import jakarta.validation.constraints.Min; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated; import java.net.URI; import java.util.List;
@RestController @Validated @RequestMapping("/periods") public class PeriodController {
 private final PeriodService service;

 public PeriodController(PeriodService service) {
  this.service = service;
 }

 @PostMapping
 public ResponseEntity<CreatePeriodResponseDto> create(@Valid @RequestBody CreatePeriodRequestDto d) {
  var x = service.create(new Period(d.code(), d.startDate(), d.endDate()));
  return ResponseEntity.created(URI.create("/periods/" + x.getPeriodId())).body(CreatePeriodResponseDto.fromPeriod(x));
 }

 @GetMapping
 public ResponseEntity<List<CreatePeriodResponseDto>> all() {
  return ResponseEntity.ok(service.findAll().stream().map(CreatePeriodResponseDto::fromPeriod).toList());
 }

 @GetMapping("/{id}")
 public ResponseEntity<CreatePeriodResponseDto> one(@PathVariable @Min(1) Long id) {
  return ResponseEntity.ok(CreatePeriodResponseDto.fromPeriod(service.findById(id)));
 }

 @PutMapping("/{id}")
 public ResponseEntity<CreatePeriodResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreatePeriodRequestDto d) {
  var x = new Period(d.code(), d.startDate(), d.endDate());
  x.setPeriodId(id);
  service.update(x);
  return ResponseEntity.ok(CreatePeriodResponseDto.fromPeriod(service.findById(id)));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
  service.delete(id);
  return ResponseEntity.noContent().build();
 }
}
