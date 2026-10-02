package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Programs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgramsJpaRepository extends JpaRepository<Programs, Long> {

    Optional<Programs> findByCode(String code);

    boolean existsByCode(String code);
}
