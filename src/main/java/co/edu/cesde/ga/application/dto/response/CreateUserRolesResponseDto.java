package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.UserRoles;

public record CreateUserRolesResponseDto(
        Long userRoleId,
        Long userId,
        Long rolesId
) {

    public static CreateUserRolesResponseDto fromUserRoles(UserRoles created) {
        return new CreateUserRolesResponseDto(
                created.getUserRoleId(),
                created.getUserId(),
                created.getRolesId()
        );
    }
}
