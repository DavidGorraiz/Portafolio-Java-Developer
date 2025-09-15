package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateBoardDto(

        @NotBlank(message = "Name is obligatory")
        String name,

        String description,
        Long ownerId
) {
}
