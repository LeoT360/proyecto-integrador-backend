package co.edu.cesde.ga.infrastructure.repository;

import co.edu.cesde.ga.domain.model.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentsJpaRepository extends JpaRepository<Enrollments, Long> {

    Optional<Enrollments> findByStudentIdAndGroupIdAndPeriodId(String studentId, String groupId, String periodId);

    boolean existsByStudentIdAndGroupIdAndPeriodId(String studentId, String groupId, String periodId);
}
