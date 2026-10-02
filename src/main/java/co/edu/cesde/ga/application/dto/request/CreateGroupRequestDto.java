package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateGroupRequestDto(
        @NotBlank
        String code,
        @NotNull
        Long programId,
        @NotNull
        Long periodId,
        @NotBlank
        String shift
) {
}
