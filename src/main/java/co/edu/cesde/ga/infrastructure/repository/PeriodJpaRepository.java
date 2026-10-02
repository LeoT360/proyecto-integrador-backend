package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodJpaRepository extends JpaRepository<Period, Long> {
}
