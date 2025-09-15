package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateListDto(

        @NotBlank(message = "Name is required")
        String name,
        Integer position,

        @NotNull(message = "List must be in a board")
        Long boardId
) {
}
