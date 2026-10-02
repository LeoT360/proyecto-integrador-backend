package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRolesJpaRepository extends JpaRepository<UserRoles, Long> {

    List<UserRoles> findByUserId(Long userId);
}
