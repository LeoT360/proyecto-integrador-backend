package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.RolesService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Roles;
import co.edu.cesde.ga.infrastructure.repository.RolesJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service public class RolesServiceImpl implements RolesService {
 private final RolesJpaRepository repository; public RolesServiceImpl(RolesJpaRepository repository){this.repository=repository;}
 public Roles create(Roles r){validate(r); if(repository.findByName(r.getName()).isPresent()) throw new RoleYaExistenteException("Ya existe un rol con ese nombre."); return repository.save(r);}
 public boolean update(Roles r){validate(r); if(r.getRolesId()==null||r.getRolesId()<=0) throw new IllegalArgumentException("El ID del rol es invalido."); findById(r.getRolesId()); var same=repository.findByName(r.getName()).orElse(null); if(same!=null&&!same.getRolesId().equals(r.getRolesId())) throw new RoleConflictoException("El nombre ya pertenece a otro rol."); repository.save(r); return true;}
 public Roles findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del rol es invalido."); return repository.findById(id).orElseThrow(()->new RoleNoEncontradoException(id));}
 public Roles findByName(String n){if(n==null||n.isBlank()) throw new IllegalArgumentException("El nombre del rol es invalido."); return repository.findByName(n).orElseThrow(()->new RoleNoEncontradoException(n));}
 public List<Roles> findAll(){return repository.findAll();} public boolean delete(Long id){findById(id); repository.deleteById(id); return true;} private void validate(Roles r){if(r==null||blank(r.getName())||blank(r.getDescription())) throw new IllegalArgumentException("Los datos del rol son invalidos.");} private boolean blank(String v){return v==null||v.trim().isBlank();}
}
