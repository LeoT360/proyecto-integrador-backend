package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.StudentService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Student;
import co.edu.cesde.ga.infrastructure.repository.StudentJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
 private final StudentJpaRepository repository;
 public StudentServiceimpl(StudentJpaRepository repository){this.repository=repository;}
 public Student create(Student s){validate(s); if(repository.existsByDocumentNumber(s.getDocumentNumber())) throw new StudentYaExistenteException("Ya existe un estudiante con ese numero de documento."); return repository.save(s);}
 public boolean update(Student s){validate(s); if(s.getStudentId()==null||s.getStudentId()<=0) throw new IllegalArgumentException("El ID del estudiante es invalido."); if(!repository.existsById(s.getStudentId())) throw new StudentNoEncontradoException(s.getStudentId()); var same=repository.findByDocumentNumber(s.getDocumentNumber()).orElse(null); if(same!=null&&!same.getStudentId().equals(s.getStudentId())) throw new StudentConflictoException("El numero de documento ya pertenece a otro estudiante."); repository.save(s); return true;}
 public Student findById(Long id){validateId(id,"estudiante"); return repository.findById(id).orElseThrow(()->new StudentNoEncontradoException(id));}
 public List<Student> findAll(){return repository.findAll();}
 public boolean delete(Long id){findById(id); repository.deleteById(id); return true;}
 private void validate(Student s){if(s==null||blank(s.getDocumentNumber())||blank(s.getFirstName())||blank(s.getLastName())||blank(s.getBirthDate())||blank(s.getStatus())) throw new IllegalArgumentException("Los datos del estudiante son invalidos.");}
 private void validateId(Long id,String n){if(id==null||id<=0) throw new IllegalArgumentException("El ID del "+n+" es invalido.");}
 private boolean blank(String v){return v==null||v.trim().isBlank();}
}
