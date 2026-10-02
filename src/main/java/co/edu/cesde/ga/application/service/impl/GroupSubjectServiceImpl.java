package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.GroupSubjectService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.GroupSubject;
import co.edu.cesde.ga.infrastructure.repository.GroupSubjectJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service public class GroupSubjectServiceImpl implements GroupSubjectService {
 private final GroupSubjectJpaRepository repository; public GroupSubjectServiceImpl(GroupSubjectJpaRepository repository){this.repository=repository;}
 public GroupSubject create(GroupSubject g){validate(g); return repository.save(g);}
 public boolean update(GroupSubject g){validate(g); if(g.getGroupSubjectId()==null||g.getGroupSubjectId()<=0) throw new IllegalArgumentException("El ID de la relacion es invalido."); findById(g.getGroupSubjectId()); repository.save(g); return true;}
 public GroupSubject findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID de la relacion es invalido."); return repository.findById(id).orElseThrow(()->new GroupSubjectNoEncontradoException(id));}
 public List<GroupSubject> findAll(){return repository.findAll();} public List<GroupSubject> findByGroupId(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del grupo es invalido."); return repository.findByGroupId(id);}
 public boolean delete(Long id){findById(id); repository.deleteById(id); return true;} private void validate(GroupSubject g){if(g==null||g.getGroupId()==null||g.getSubjectId()==null||g.getTeacherId()==null) throw new IllegalArgumentException("Los datos de la relacion son invalidos.");}
}
