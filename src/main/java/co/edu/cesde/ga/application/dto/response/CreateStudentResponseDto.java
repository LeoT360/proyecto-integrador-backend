package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Student;

public record CreateStudentResponseDto(
        Long studentId,
        Long userId,
        String documentType,
        String documentNumber,
        String firstName,
        String lastName,
        String status,
        String birthDate
) {

    public static CreateStudentResponseDto fromStudent(Student created) {
        return new CreateStudentResponseDto(
                created.getStudentId(),
                created.getUserId(),
                created.getDocumentType(),
                created.getDocumentNumber(),
                created.getFirstName(),
                created.getLastName(),
                created.getStatus(),
                created.getBirthDate()
        );
    }
}
