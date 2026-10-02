package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateGradesRequestDto(
        @NotNull
        Long groupSubjectId,
        @NotNull
        Long studentId,
        @NotNull
        @Min(value = 0, message = "La calificación no puede ser menor que 0")
        @Max(value = 5, message = "La calificación no puede ser mayor que 5")
        Double finalScore,
        @NotBlank
        String observation
) {
}
