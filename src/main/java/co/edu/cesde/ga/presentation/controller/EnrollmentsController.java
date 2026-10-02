package co.edu.cesde.ga.presentation.controller;

import co.edu.cesde.ga.application.dto.request.CreateEnrollmentsRequestDto;
import co.edu.cesde.ga.application.dto.response.CreateEnrollmentsResponseDto;
import co.edu.cesde.ga.application.service.EnrollmentsService;
import co.edu.cesde.ga.domain.model.Enrollments;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentsController {
    private final EnrollmentsService service;
    public EnrollmentsController(EnrollmentsService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<CreateEnrollmentsResponseDto> create(@Valid @RequestBody CreateEnrollmentsRequestDto d) {
        var x = service.create(new Enrollments(d.studentId(), d.groupId(), d.periodId(), d.status()));
        return ResponseEntity.created(URI.create("/enrollments/" + x.getEnrollmentId())).body(CreateEnrollmentsResponseDto.fromEnrollments(x));
    }
    @GetMapping
    public ResponseEntity<List<CreateEnrollmentsResponseDto>> all() {
        return ResponseEntity.ok(service.findAll().stream().map(CreateEnrollmentsResponseDto::fromEnrollments).toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CreateEnrollmentsResponseDto> one(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(CreateEnrollmentsResponseDto.fromEnrollments(service.findById(id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CreateEnrollmentsResponseDto> update(@PathVariable @Min(1) Long id, @Valid @RequestBody CreateEnrollmentsRequestDto d) {
        var x = new Enrollments(id, d.studentId(), d.groupId(), d.periodId(), d.status());
        service.update(x);
        return ResponseEntity.ok(CreateEnrollmentsResponseDto.fromEnrollments(service.findById(id)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) { service.delete(id); return ResponseEntity.noContent().build(); }
}
