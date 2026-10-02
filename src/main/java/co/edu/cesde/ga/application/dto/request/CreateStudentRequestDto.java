package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateStudentRequestDto(
        @NotNull
        Long userId,
        @NotBlank
        String documentType,
        @NotBlank
        String documentNumber,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String status,
        @NotBlank
        String birthDate
) {
}
