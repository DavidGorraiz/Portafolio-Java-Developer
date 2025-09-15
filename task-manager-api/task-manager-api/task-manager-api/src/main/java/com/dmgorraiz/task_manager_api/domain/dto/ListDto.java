package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ListDto(
        Long id,

        @NotBlank(message = "Name is required")
        String name,
        Integer position,

        @NotNull(message = "List must be in a board")
        Long boardId,
        List<TaskDto> tasksDto
) {
}
