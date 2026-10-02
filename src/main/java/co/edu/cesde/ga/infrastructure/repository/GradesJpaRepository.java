package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradesJpaRepository extends JpaRepository<Grades, Long> {

    List<Grades> findByStudentId(Long studentId);
}
