package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.ProgramsService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Programs;
import co.edu.cesde.ga.infrastructure.repository.ProgramsJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProgramsServiceImpl implements ProgramsService {
 private final ProgramsJpaRepository repository; public ProgramsServiceImpl(ProgramsJpaRepository repository){this.repository=repository;}
 public Programs create(Programs p){validate(p); if(repository.existsByCode(p.getCode())) throw new ProgramYaExistenteException("Ya existe un programa con ese codigo."); return repository.save(p);}
 public boolean update(Programs p){validate(p); if(p.getProgramId()==null||p.getProgramId()<=0) throw new IllegalArgumentException("El ID del programa es invalido."); if(!repository.existsById(p.getProgramId())) throw new ProgramNoEncontradoException(p.getProgramId()); var same=repository.findByCode(p.getCode()).orElse(null); if(same!=null&&!same.getProgramId().equals(p.getProgramId())) throw new ProgramConflictoException("El codigo ya pertenece a otro programa."); repository.save(p); return true;}
 public Programs findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del programa es invalido."); return repository.findById(id).orElseThrow(()->new ProgramNoEncontradoException(id));}
 public List<Programs> findAll(){return repository.findAll();} public boolean delete(Long id){findById(id); repository.deleteById(id); return true;}
 private void validate(Programs p){if(p==null||blank(p.getCode())||blank(p.getName())) throw new IllegalArgumentException("Los datos del programa son invalidos.");} private boolean blank(String v){return v==null||v.trim().isBlank();}
}
