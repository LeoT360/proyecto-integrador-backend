package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Grades;

import java.util.List;

public interface GradesService {

    Grades create(Grades grade);

    boolean update(Grades gradeUpdate);

    Grades findById(Long gradeId);

    List<Grades> findAll();

    List<Grades> findByStudentId(Long studentId);

    boolean delete(Long gradeId);
}