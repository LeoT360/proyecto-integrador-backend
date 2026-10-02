package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Group;

public record CreateGroupResponseDto(
        Long groupId,
        String code,
        Long programId,
        Long periodId,
        String shift
) {

    public static CreateGroupResponseDto fromGroup(Group created) {
        return new CreateGroupResponseDto(
                created.getGroupId(),
                created.getCode(),
                created.getProgramId(),
                created.getPeriodId(),
                created.getShift()
        );
    }
}
