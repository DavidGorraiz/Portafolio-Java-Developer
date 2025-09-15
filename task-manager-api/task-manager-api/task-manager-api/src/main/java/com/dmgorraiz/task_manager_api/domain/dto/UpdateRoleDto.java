package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateRoleDto(
        @NotBlank(message = "You have to provide a name to the role")
        String role
) {
}
