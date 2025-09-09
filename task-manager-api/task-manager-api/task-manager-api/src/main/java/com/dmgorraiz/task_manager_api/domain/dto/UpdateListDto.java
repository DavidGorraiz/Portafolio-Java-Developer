package com.dmgorraiz.task_manager_api.domain.dto;

public record UpdateListDto(
        String name,
        Integer position,
        Long boardId
) {
}
