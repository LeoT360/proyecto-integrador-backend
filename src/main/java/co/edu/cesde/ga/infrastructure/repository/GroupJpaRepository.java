package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupJpaRepository extends JpaRepository<Group, Long> {

    Optional<Group> findByCode(String code);
}
