package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AttachmentDto(
        Long id,

        @NotBlank(message = "Attachment must have a url to the file")
        String fileUrl,

        @NotNull(message = "Attachment must belong to a user")
        Long userId,

        @NotNull(message = "Attachment must be associated to a task")
        Long taskId
) {
}
