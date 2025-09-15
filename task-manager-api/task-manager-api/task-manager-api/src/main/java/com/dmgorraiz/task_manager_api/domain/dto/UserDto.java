package com.dmgorraiz.task_manager_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserDto(

        Long id,

        @NotBlank(message = "Username is obligatory")
        String username,

        @NotBlank(message = "Password is obligatory")
        String password,

        Boolean locked,
        Boolean disable,
        List<BoardDto> boardsDto
) {
}
