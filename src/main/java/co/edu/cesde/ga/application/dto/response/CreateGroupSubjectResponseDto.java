package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.GroupSubject;

public record CreateGroupSubjectResponseDto(
        Long groupSubjectId,
        Long groupId,
        Long subjectId,
        Long teacherId
) {

    public static CreateGroupSubjectResponseDto fromGroupSubject(GroupSubject created) {
        return new CreateGroupSubjectResponseDto(
                created.getGroupSubjectId(),
                created.getGroupId(),
                created.getSubjectId(),
                created.getTeacherId()
        );
    }
}
