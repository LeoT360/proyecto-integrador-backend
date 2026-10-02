package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePeriodRequestDto(
        @NotBlank
        String code,
        @NotBlank
        String startDate,
        @NotBlank
        String endDate
) {
}
