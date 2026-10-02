package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEnrollmentsRequestDto(
        @NotBlank
        String studentId,
        @NotBlank
        String groupId,
        @NotBlank
        String periodId,
        @NotBlank
        String status
) {
}
