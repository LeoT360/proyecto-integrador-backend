package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Roles;

import java.util.List;

public interface RolesService {

    Roles create(Roles role);

    boolean update(Roles roleUpdate);

    Roles findById(Long roleId);

    Roles findByName(String name);

    List<Roles> findAll();

    boolean delete(Long roleId);
}