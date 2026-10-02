package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRolesRequestDto(
        @NotNull
        Long userId,
        @NotNull
        Long rolesId
) {
}
