package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateCommentDto(
        String content,
        String username,
        Long taskId
) {
}
