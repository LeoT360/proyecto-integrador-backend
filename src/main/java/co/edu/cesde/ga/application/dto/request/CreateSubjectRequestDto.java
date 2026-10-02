package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSubjectRequestDto(
        @NotBlank
        String code,
        @NotBlank
        String name,
        @NotNull
        @Min(value = 1, message = "Los créditos deben ser mayores que 0")
        Integer credits,
        @NotNull
        Long programId
) {
}
