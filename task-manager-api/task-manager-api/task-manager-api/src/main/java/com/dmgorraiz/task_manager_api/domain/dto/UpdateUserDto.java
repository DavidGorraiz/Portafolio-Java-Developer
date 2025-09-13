package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateUserDto(
        String username,
        String password,
        Boolean locked,
        Boolean disable
) {
}
