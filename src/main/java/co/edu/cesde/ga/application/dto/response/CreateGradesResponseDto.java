package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Grades;

public record CreateGradesResponseDto(
        Long gradeId,
        Long groupSubjectId,
        Long studentId,
        Double finalScore,
        String observation
) {

    public static CreateGradesResponseDto fromGrades(Grades created) {
        return new CreateGradesResponseDto(
                created.getGradeId(),
                created.getGroupSubjectId(),
                created.getStudentId(),
                created.getFinalScore(),
                created.getObservation()
        );
    }
}
