package co.edu.cesde.ga.application.service;

import co.edu.cesde.ga.domain.model.Subject;

import java.util.List;

public interface SubjectService {

    Subject create(Subject subject);

    boolean update(Subject updateSubject);

    Subject findById(Long subjectId);

    Subject findByCode(String code);

    List<Subject> findAll();

    boolean delete(Long subjectId);
}