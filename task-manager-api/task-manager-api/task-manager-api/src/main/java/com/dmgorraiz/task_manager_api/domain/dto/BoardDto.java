package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record BoardDto(
        Long id,

        @NotBlank(message = "Name is obligatory")
        String name,
        String description,
        Long ownerId,
        List<BoardMemberDto> membersDto
) {
}
