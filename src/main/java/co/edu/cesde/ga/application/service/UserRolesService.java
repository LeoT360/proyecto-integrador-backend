package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.UserRoles;
import java.util.List;

public interface UserRolesService {
    List<UserRoles> getAll();
    UserRoles create(UserRoles userRole);
    void delete(int id);

    boolean update(UserRoles userRoleUpdate);

    UserRoles findById(Long id);

    List<UserRoles> findByUserId(Long userId);

    List<UserRoles> findAll();

    boolean delete(Long id);
}
