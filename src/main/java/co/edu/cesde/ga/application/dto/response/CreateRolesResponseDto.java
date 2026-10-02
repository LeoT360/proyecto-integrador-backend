package co.edu.cesde.ga.application.dto.response;

import co.edu.cesde.ga.domain.model.Roles;

public record CreateRolesResponseDto(
        Long rolesId,
        String name,
        String description
) {

    public static CreateRolesResponseDto fromRoles(Roles created) {
        return new CreateRolesResponseDto(
                created.getRolesId(),
                created.getName(),
                created.getDescription()
        );
    }
}
