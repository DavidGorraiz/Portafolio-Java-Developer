package com.dmgorraiz.task_manager_api.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public record TaskDto(
        Long id,
        String title,
        String description,
        LocalDateTime dueDate,
        Integer position,
        String status,
        Long listId,
        Long boardId,
        List<AttachmentDto> attachmentDtos,
        List<CommentDto> commentDtos
) {
}
