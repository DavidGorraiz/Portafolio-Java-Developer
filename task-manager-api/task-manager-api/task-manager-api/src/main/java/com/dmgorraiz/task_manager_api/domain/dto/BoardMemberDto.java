package com.dmgorraiz.task_manager_api.domain.dto;

public record BoardMemberDto(
        Long id,
        Long boardId,
        Long userId,
        String roleInBoard
) {
}
