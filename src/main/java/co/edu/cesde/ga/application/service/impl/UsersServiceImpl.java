package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.application.service.UsersService;
import co.edu.cesde.ga.domain.exceptions.*;
import co.edu.cesde.ga.domain.model.Users;
import co.edu.cesde.ga.infrastructure.repository.UsersJpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service public class UsersServiceImpl implements UsersService {
 private final UsersJpaRepository repository; public UsersServiceImpl(UsersJpaRepository repository){this.repository=repository;}
 public Users create(Users u){validate(u); if(repository.existsByUsername(u.getUsername())) throw new UserYaExistenteException("El username ya existe."); if(repository.existsByEmail(u.getEmail())) throw new UserYaExistenteException("El email ya existe."); return repository.save(u);}
 public boolean update(Users u){validate(u); if(u.getUserId()==null||u.getUserId()<=0) throw new IllegalArgumentException("El ID del usuario es invalido."); findById(u.getUserId()); var same=repository.findByUsername(u.getUsername()).orElse(null); if(same!=null&&!same.getUserId().equals(u.getUserId())) throw new UserConflictoException("El username ya pertenece a otro usuario."); repository.save(u); return true;}
 public Users findById(Long id){if(id==null||id<=0) throw new IllegalArgumentException("El ID del usuario es invalido."); return repository.findById(id).orElseThrow(()->new UserNoEncontradoException(id));}
 public Users findByUsername(String n){if(n==null||n.isBlank()) throw new IllegalArgumentException("El username es invalido."); return repository.findByUsername(n).orElseThrow(()->new UserNoEncontradoException(n));}
 public List<Users> findAll(){return repository.findAll();} public boolean delete(Long id){findById(id); repository.deleteById(id); return true;} private void validate(Users u){if(u==null||blank(u.getUsername())||blank(u.getEmail())||blank(u.getPasswordHash())||blank(u.getStatus())) throw new IllegalArgumentException("Los datos del usuario son invalidos.");} private boolean blank(String v){return v==null||v.trim().isBlank();}
}
