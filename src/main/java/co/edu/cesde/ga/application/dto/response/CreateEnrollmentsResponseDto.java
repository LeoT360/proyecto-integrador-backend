package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Enrollments;

public record CreateEnrollmentsResponseDto(
        Long enrollmentId,
        String studentId,
        String groupId,
        String periodId,
        String status
) {

    public static CreateEnrollmentsResponseDto fromEnrollments(Enrollments created) {
        return new CreateEnrollmentsResponseDto(
                created.getEnrollmentId(),
                created.getStudentId(),
                created.getGroupId(),
                created.getPeriodId(),
                created.getStatus()
        );
    }
}
