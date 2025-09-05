package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;

import java.util.List;

public interface BoardRepository {
    List<BoardDto> getAll();
}
