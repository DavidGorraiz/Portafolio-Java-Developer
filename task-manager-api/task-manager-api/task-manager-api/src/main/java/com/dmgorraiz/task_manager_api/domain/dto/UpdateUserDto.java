package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(
        @NotBlank(message = "Username is obligatory")
        String username,

        @NotBlank(message = "Password is obligatory")
        String password,

        @NotBlank(message = "Email is obligatory")
        String email,

        Boolean locked,
        Boolean disable
) {
}
