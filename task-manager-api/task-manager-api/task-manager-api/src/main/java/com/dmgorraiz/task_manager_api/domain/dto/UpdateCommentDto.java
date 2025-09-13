package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateCommentDto(
        String content,
        Long userId,
        Long taskId
) {
}
