package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProgramsRequestDto(
        @NotBlank
        String code,
        @NotBlank
        String name
) {
}
