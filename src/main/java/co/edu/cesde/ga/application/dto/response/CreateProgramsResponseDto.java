package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Programs;

public record CreateProgramsResponseDto(
        Long programId,
        String code,
        String name
) {

    public static CreateProgramsResponseDto fromPrograms(Programs created) {
        return new CreateProgramsResponseDto(
                created.getProgramId(),
                created.getCode(),
                created.getName()
        );
    }
}
