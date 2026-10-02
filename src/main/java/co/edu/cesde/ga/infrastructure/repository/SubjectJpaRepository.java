package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectJpaRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findByCode(String code);
}
