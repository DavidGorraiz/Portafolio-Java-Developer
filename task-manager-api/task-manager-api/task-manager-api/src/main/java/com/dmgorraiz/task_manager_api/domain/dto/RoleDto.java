package com.dmgorraiz.task_manager_api.domain.dto;

import java.util.List;

public record RoleDto(
        String role,
        List<UserDto> usersDto
) {
}
