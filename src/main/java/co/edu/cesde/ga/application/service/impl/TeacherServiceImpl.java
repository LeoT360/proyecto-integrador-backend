package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.TeacherService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Teacher;
import co.edu.cesde.ga.infrastructure.repository.TeacherJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
 private final TeacherJpaRepository repository;
 public TeacherServiceImpl(TeacherJpaRepository repository){this.repository=repository;}
 public Teacher create(Teacher t){validate(t); if(repository.existsByDocumentNumber(t.getDocumentNumber())) throw new TeacherYaExistenteException("Ya existe un profesor con ese numero de documento."); return repository.save(t);}
 public boolean update(Teacher t){validate(t); if(t.getTeacherId()==null||t.getTeacherId()<=0) throw new IllegalArgumentException("El ID del profesor es invalido."); if(!repository.existsById(t.getTeacherId())) throw new TeacherNoEncontradoException(t.getTeacherId()); var same=repository.findByDocumentNumber(t.getDocumentNumber()).orElse(null); if(same!=null&&!same.getTeacherId().equals(t.getTeacherId())) throw new TeacherConflictoException("El numero de documento ya pertenece a otro profesor."); repository.save(t); return true;}
 public Teacher findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del profesor es invalido."); return repository.findById(id).orElseThrow(()->new TeacherNoEncontradoException(id));}
 public List<Teacher> findAll(){return repository.findAll();}
 public boolean delete(Long id){findById(id); repository.deleteById(id); return true;}
 private void validate(Teacher t){if(t==null||blank(t.getDocumentNumber())||blank(t.getFirstName())||blank(t.getLastName())||blank(t.getStatus())) throw new IllegalArgumentException("Los datos del profesor son invalidos.");}
 private boolean blank(String v){return v==null||v.trim().isBlank();}
}
