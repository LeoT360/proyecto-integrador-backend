package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Teacher;

public record CreateTeacherResponseDto(
        Long teacherId,
        Long userId,
        String code,
        String documentType,
        String documentNumber,
        String firstName,
        String lastName,
        String status
) {

    public static CreateTeacherResponseDto fromTeacher(Teacher created) {
        return new CreateTeacherResponseDto(
                created.getTeacherId(),
                created.getUserId(),
                created.getCode(),
                created.getDocumentType(),
                created.getDocumentNumber(),
                created.getFirstName(),
                created.getLastName(),
                created.getStatus()
        );
    }
}
