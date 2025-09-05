package com.dmgorraiz.task_manager_api.domain.dto;

import java.util.List;

public record ListDto(
        Long id,
        String name,
        Integer position,
        Long boardId,
        List<TaskDto> tasksDto
) {
}
