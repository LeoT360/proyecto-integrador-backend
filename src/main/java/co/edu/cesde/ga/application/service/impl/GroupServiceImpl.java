package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.GroupService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Group;
import co.edu.cesde.ga.infrastructure.repository.GroupJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
 private final GroupJpaRepository repository; public GroupServiceImpl(GroupJpaRepository repository){this.repository=repository;}
 public Group create(Group g){validate(g); if(repository.findByCode(g.getCode()).isPresent()) throw new GroupYaExistenteException("Ya existe un grupo con ese codigo."); return repository.save(g);}
 public boolean update(Group g){validate(g); var current=findByCode(g.getCode()); g.setGroupId(current.getGroupId()); repository.save(g); return true;}
 public Group findByCode(String code){if(blank(code)) throw new IllegalArgumentException("El codigo del grupo es invalido."); return repository.findByCode(code).orElseThrow(()->new GroupNoEncontradoException(code));}
 public List<Group> findAll(){return repository.findAll();} public boolean delete(String code){var g=findByCode(code); repository.delete(g); return true;}
 private void validate(Group g){if(g==null||blank(g.getCode())||g.getProgramId()==null||g.getPeriodId()==null||blank(g.getShift())) throw new IllegalArgumentException("Los datos del grupo son invalidos.");} private boolean blank(String v){return v==null||v.trim().isBlank();}
}
