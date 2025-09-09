package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateBoardDto(
        String name,
        String description,
        String username
) {
}
