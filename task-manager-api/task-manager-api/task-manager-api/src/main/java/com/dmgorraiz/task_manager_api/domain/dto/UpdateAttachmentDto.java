package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateAttachmentDto(
        String fileUrl,
        Long userId,
        Long taskId
) {
}
