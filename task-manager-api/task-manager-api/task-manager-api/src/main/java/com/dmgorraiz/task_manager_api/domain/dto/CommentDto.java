package com.dmgorraiz.task_manager_api.domain.dto;

public record CommentDto(
        Long id,
        String content,
        Long userId,
        Long taskId
) {
}
