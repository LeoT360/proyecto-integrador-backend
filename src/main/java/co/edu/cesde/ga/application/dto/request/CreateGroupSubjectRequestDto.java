package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateGroupSubjectRequestDto(
        @NotNull
        Long groupId,
        @NotNull
        Long subjectId,
        @NotNull
        Long teacherId
) {
}
