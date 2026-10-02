package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher create (Teacher teacher);

    boolean update (Teacher updateTeacher);

    boolean delete (Long teacherId);

    Teacher findById (Long teacherId);

    List<Teacher> findAll();

}