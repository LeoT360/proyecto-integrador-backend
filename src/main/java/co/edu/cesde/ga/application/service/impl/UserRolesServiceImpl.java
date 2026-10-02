package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.UserRolesService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.UserRoles;
import co.edu.cesde.ga.infrastructure.repository.UserRolesJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service public class UserRolesServiceImpl implements UserRolesService {
 private final UserRolesJpaRepository repository; public UserRolesServiceImpl(UserRolesJpaRepository repository){this.repository=repository;}
 public List<UserRoles> getAll(){return repository.findAll();} public UserRoles create(UserRoles u){validate(u); return repository.save(u);}
 public void delete(int id){delete((long)id);} public boolean update(UserRoles u){validate(u); if(u.getUserRoleId()==null||u.getUserRoleId()<=0) throw new IllegalArgumentException("El ID de la relacion es invalido."); findById(u.getUserRoleId()); repository.save(u); return true;}
 public UserRoles findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID de la relacion es invalido."); return repository.findById(id).orElseThrow(()->new UserRoleNoEncontradoException(id));}
 public List<UserRoles> findByUserId(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del usuario es invalido."); return repository.findByUserId(id);}
 public List<UserRoles> findAll(){return repository.findAll();} public boolean delete(Long id){findById(id); repository.deleteById(id); return true;} private void validate(UserRoles u){if(u==null||u.getUserId()==null||u.getRolesId()==null) throw new IllegalArgumentException("Los datos de la relacion son invalidos.");}
}
