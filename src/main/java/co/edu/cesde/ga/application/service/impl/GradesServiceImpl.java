package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.GradesService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Grades;
import co.edu.cesde.ga.infrastructure.repository.GradesJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service public class GradesServiceImpl implements GradesService {
 private final GradesJpaRepository repository; public GradesServiceImpl(GradesJpaRepository repository){this.repository=repository;}
 public Grades create(Grades g){validate(g); return repository.save(g);}
 public boolean update(Grades g){validate(g); if(g.getGradeId()==null||g.getGradeId()<=0) throw new IllegalArgumentException("El ID de la nota es invalido."); findById(g.getGradeId()); repository.save(g); return true;}
 public Grades findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID de la nota es invalido."); return repository.findById(id).orElseThrow(()->new GradeNoEncontradoException(id));}
 public List<Grades> findAll(){return repository.findAll();} public List<Grades> findByStudentId(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del estudiante es invalido."); return repository.findByStudentId(id);}
 public boolean delete(Long id){findById(id); repository.deleteById(id); return true;} private void validate(Grades g){if(g==null||g.getStudentId()==null||g.getGroupSubjectId()==null||g.getFinalScore()==null||g.getFinalScore()<0||g.getFinalScore()>5) throw new IllegalArgumentException("Los datos de la nota son invalidos.");}
}
