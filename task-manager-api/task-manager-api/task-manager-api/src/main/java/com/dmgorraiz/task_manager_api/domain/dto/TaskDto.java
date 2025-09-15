package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record TaskDto(
        Long id,

        @NotBlank(message = "The task must have a title")
        String title,

        String description,

        @FutureOrPresent(message = "Due date have to be after or the same day as today")
        LocalDateTime dueDate,

        Integer position,
        String status,

        @NotNull(message = "Task must be in a list")
        Long listId,

        @NotNull(message = "Task must be in a board")
        Long boardId,

        List<AttachmentDto> attachmentDtos,
        List<CommentDto> commentDtos
) {
}
