package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.EnrollmentsService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Enrollments;
import co.edu.cesde.ga.infrastructure.repository.EnrollmentsJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service public class EnrollmentsServiceImpl implements EnrollmentsService {
 private final EnrollmentsJpaRepository repository; public EnrollmentsServiceImpl(EnrollmentsJpaRepository repository){this.repository=repository;}
 public Enrollments create(Enrollments e){validate(e); if(repository.existsByStudentIdAndGroupIdAndPeriodId(e.getStudentId(),e.getGroupId(),e.getPeriodId())) throw new EnrollmentYaExistenteException("Ya existe una inscripcion para ese estudiante, grupo y periodo."); return repository.save(e);}
 public boolean update(Enrollments e){validate(e); if(e.getEnrollmentId()==null||e.getEnrollmentId()<=0) throw new IllegalArgumentException("El ID de la inscripcion es invalido."); findById(e.getEnrollmentId()); var same=repository.findByStudentIdAndGroupIdAndPeriodId(e.getStudentId(),e.getGroupId(),e.getPeriodId()).orElse(null); if(same!=null&&!same.getEnrollmentId().equals(e.getEnrollmentId())) throw new EnrollmentConflictoException("Ya existe otra inscripcion para esos datos."); repository.save(e); return true;}
 public Enrollments findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID de la inscripcion es invalido."); return repository.findById(id).orElseThrow(()->new EnrollmentNoEncontradoException(id));}
 public List<Enrollments> findAll(){return repository.findAll();} public boolean delete(Long id){findById(id); repository.deleteById(id); return true;} private void validate(Enrollments e){if(e==null||blank(e.getStudentId())||blank(e.getGroupId())||blank(e.getPeriodId())||blank(e.getStatus())) throw new IllegalArgumentException("Los datos de la inscripcion son invalidos.");} private boolean blank(String v){return v==null||v.trim().isBlank();}
}
