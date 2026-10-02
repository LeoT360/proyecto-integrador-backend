package co.edu.cesde.ga.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUsersRequestDto(
        @NotBlank
        String username,
        @Email
        String email,
        @NotBlank
        String passwordHash,
        @NotBlank
        String status
) {
}
