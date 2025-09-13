package com.dmgorraiz.task_manager_api.domain.dto;

public record AttachmentDto(
        Long id,
        String fileUrl,
        Long userId,
        Long taskId
) {
}
