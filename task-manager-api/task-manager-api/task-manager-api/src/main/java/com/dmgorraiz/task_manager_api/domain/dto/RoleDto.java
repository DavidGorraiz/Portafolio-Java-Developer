package com.dmgorraiz.task_manager_api.domain.dto;

import java.util.List;

public record RoleDto(
        Long id,
        String role,
        List<UserDto> usersDto
) {
}
