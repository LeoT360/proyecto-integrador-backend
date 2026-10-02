package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Group;
import java.util.List;

public interface GroupService {

    Group create(Group group);

    boolean update(Group updateGroup);

    boolean delete(String groupCode);

    Group findByCode(String groupCode);

    List<Group> findAll();
}