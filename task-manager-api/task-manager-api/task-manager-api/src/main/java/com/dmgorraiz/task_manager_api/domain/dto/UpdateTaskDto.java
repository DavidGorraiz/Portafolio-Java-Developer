package com.dmgorraiz.task_manager_api.domain.dto;

import java.time.LocalDateTime;

public record UpdateTaskDto(
        String title,
        String description,
        LocalDateTime dueDate,
        Integer position,
        String status,
        Long listId,
        Long boardId
) {
}
