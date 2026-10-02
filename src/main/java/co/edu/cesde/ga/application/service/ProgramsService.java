package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Programs;

import java.util.List;

public interface ProgramsService {

    Programs create(Programs program);

    boolean update(Programs updateProgram);

    boolean delete(Long programId);

    Programs findById(Long programId);

    List<Programs> findAll();


}