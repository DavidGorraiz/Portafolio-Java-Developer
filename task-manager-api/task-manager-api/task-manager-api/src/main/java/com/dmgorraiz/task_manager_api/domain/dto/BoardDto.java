package com.dmgorraiz.task_manager_api.domain.dto;

import java.util.List;

public record BoardDto(
        Long id,
        String name,
        String description,
        Long ownerId,
        List<BoardMemberDto> membersDto
) {
}
