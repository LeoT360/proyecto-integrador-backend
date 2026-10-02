package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.SubjectService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Subject;
import co.edu.cesde.ga.infrastructure.repository.SubjectJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
 private final SubjectJpaRepository repository; public SubjectServiceImpl(SubjectJpaRepository repository){this.repository=repository;}
 public Subject create(Subject s){validate(s); if(repository.findByCode(s.getCode()).isPresent()) throw new SubjectYaExistenteException("Ya existe una materia con ese codigo."); return repository.save(s);}
 public boolean update(Subject s){validate(s); if(s.getSubjectId()==null||s.getSubjectId()<=0) throw new IllegalArgumentException("El ID de la materia es invalido."); if(!repository.existsById(s.getSubjectId())) throw new SubjectNoEncontradoException(s.getSubjectId()); var same=repository.findByCode(s.getCode()).orElse(null); if(same!=null&&!same.getSubjectId().equals(s.getSubjectId())) throw new SubjectConflictoException("El codigo ya pertenece a otra materia."); repository.save(s); return true;}
 public Subject findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID de la materia es invalido."); return repository.findById(id).orElseThrow(()->new SubjectNoEncontradoException(id));}
 public Subject findByCode(String code){if(blank(code)) throw new IllegalArgumentException("El codigo es invalido."); return repository.findByCode(code).orElseThrow(()->new SubjectNoEncontradoException(code));}
 public List<Subject> findAll(){return repository.findAll();} public boolean delete(Long id){findById(id); repository.deleteById(id); return true;}
 private void validate(Subject s){if(s==null||blank(s.getCode())||blank(s.getName())||s.getCredits()==null||s.getCredits()<=0||s.getProgramId()==null) throw new IllegalArgumentException("Los datos de la materia son invalidos.");} private boolean blank(String v){return v==null||v.trim().isBlank();}
}
