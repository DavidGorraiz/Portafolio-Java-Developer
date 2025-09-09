package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateUserDto(
        String password,
        Boolean locked,
        Boolean disable
) {
}
