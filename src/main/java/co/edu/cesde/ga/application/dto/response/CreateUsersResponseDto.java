package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Users;

public record CreateUsersResponseDto(
        Long userId,
        String username,
        String email,
        String passwordHash,
        String status
) {

    public static CreateUsersResponseDto fromUsers(Users created) {
        return new CreateUsersResponseDto(
                created.getUserId(),
                created.getUsername(),
                created.getEmail(),
                created.getPasswordHash(),
                created.getStatus()
        );
    }
}
