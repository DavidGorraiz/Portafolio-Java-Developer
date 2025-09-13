package com.dmgorraiz.task_manager_api.domain.dto;

import java.util.List;

public record UserDto(
        Long id,
        String username,
        String password,
        Boolean locked,
        Boolean disable,
        List<BoardDto> boardsDto
) {
}
