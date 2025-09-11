package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateAttachmentDto(
        String fileUrl,
        String username,
        Long taskId
) {
}
