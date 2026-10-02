package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.PeriodService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Period;
import co.edu.cesde.ga.infrastructure.repository.PeriodJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service public class PeriodServiceImpl implements PeriodService {
 private final PeriodJpaRepository repository; public PeriodServiceImpl(PeriodJpaRepository repository){this.repository=repository;}
 public Period create(Period p){validate(p); return repository.save(p);} public boolean update(Period p){validate(p); if(p.getPeriodId()==null||p.getPeriodId()<=0) throw new IllegalArgumentException("El ID del periodo es invalido."); findById(p.getPeriodId()); repository.save(p); return true;}
 public Period findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del periodo es invalido."); return repository.findById(id).orElseThrow(()->new PeriodNoEncontradoException(id));}
 public List<Period> findAll(){return repository.findAll();} public boolean delete(Long id){findById(id); repository.deleteById(id); return true;} private void validate(Period p){if(p==null||blank(p.getCode())||blank(p.getStartDate())||blank(p.getEndDate())) throw new IllegalArgumentException("Los datos del periodo son invalidos.");} private boolean blank(String v){return v==null||v.trim().isBlank();}
}
