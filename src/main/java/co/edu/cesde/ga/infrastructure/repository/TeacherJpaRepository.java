package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherJpaRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByDocumentNumber(String documentNumber);

    boolean existsByDocumentNumber(String documentNumber);
}
