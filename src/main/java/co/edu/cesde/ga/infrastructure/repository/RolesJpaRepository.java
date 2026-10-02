package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesJpaRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByName(String name);
}
