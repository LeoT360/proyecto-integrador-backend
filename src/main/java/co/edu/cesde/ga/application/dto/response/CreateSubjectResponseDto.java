package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Subject;

public record CreateSubjectResponseDto(
        Long subjectId,
        String code,
        String name,
        Integer credits,
        Long programId
) {

    public static CreateSubjectResponseDto fromSubject(Subject created) {
        return new CreateSubjectResponseDto(
                created.getSubjectId(),
                created.getCode(),
                created.getName(),
                created.getCredits(),
                created.getProgramId()
        );
    }
}
