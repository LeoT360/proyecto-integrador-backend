package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Student;
import java.util.List;

public interface StudentService {

    Student create(Student student);

    boolean update (Student student);

    Student findById(Long studentId);

    boolean delete (Long studentId);

    List<Student> findAll();
}
