package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    boolean existsByDocumentNumber(String documentNumber);

    Optional<Student> findByDocumentNumber(String documentNumber);
}
