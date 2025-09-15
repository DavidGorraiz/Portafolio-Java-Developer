package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateCommentDto(
        String content,

        @NotNull(message = "Comment must be write by a user")
        Long userId,

        @NotNull(message = "Comment must belong to a task")
        Long taskId
) {
}
