package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RoleDto(
        Long id,

        @NotBlank(message = "You have to provide a name to the role")
        String role,

        List<UserDto> usersDto
) {
}
