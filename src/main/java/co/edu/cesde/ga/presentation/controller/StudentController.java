package co.edu.cesde.ga.presentation.controller;

import co.edu.cesde.ga.application.dto.request.CreateStudentRequestDto;
import co.edu.cesde.ga.application.dto.response.CreateStudentResponseDto;
import co.edu.cesde.ga.application.service.StudentService;
import co.edu.cesde.ga.domain.model.Student;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import java.net.URI; import java.util.List;

@RestController @Validated @RequestMapping("/students")
public class StudentController {

 private final StudentService service;
 public StudentController(StudentService service){this.service=service;}

 @PostMapping
 public ResponseEntity<CreateStudentResponseDto> create(@Valid @RequestBody CreateStudentRequestDto d){
  var x=service.create(new Student(d.userId(),d.documentType(),d.documentNumber(),d.firstName(),d.lastName(),d.status(),d.birthDate()));
  var r=CreateStudentResponseDto.fromStudent(x); return ResponseEntity.created(URI.create("/students/"+x.getStudentId())).body(r);
 }
 @GetMapping
 public ResponseEntity<List<CreateStudentResponseDto>> findAll(){
  return ResponseEntity.ok(service.findAll().stream().map(CreateStudentResponseDto::fromStudent).toList());
 }
 @GetMapping("/{id}")
 public ResponseEntity<CreateStudentResponseDto> findById(@PathVariable @Min(1) Long id){
  return ResponseEntity.ok(CreateStudentResponseDto.fromStudent(service.findById(id)));
 }
 @PutMapping("/{id}")
 public ResponseEntity<CreateStudentResponseDto> update(@PathVariable @Min(1) Long id,@Valid @RequestBody CreateStudentRequestDto d){
  var x=new Student(d.userId(),d.documentType(),d.documentNumber(),d.firstName(),d.lastName(),d.status(),d.birthDate()); x.setStudentId(id); service.update(x);
  return ResponseEntity.ok(CreateStudentResponseDto.fromStudent(service.findById(id)));
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id){
  service.delete(id);
  return ResponseEntity.noContent().build();}
}
