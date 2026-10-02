package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Users;

import java.util.List;

public interface UsersService {

    Users create(Users user);

    boolean update(Users updateUser);

    Users findById(Long userId);

    Users findByUsername(String username);

    List<Users> findAll();

    boolean delete(Long userId);
}