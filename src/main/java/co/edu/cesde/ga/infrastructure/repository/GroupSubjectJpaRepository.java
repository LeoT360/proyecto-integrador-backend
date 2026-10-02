package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.GroupSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupSubjectJpaRepository extends JpaRepository<GroupSubject, Long> {

    List<GroupSubject> findByGroupId(Long groupId);
}
