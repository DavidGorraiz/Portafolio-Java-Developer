package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateBoardDto;

import java.util.List;

public interface BoardRepository {
    List<BoardDto> getAll();
    BoardDto getById(long id);
    BoardDto save(BoardDto boardDto);
    BoardDto update(long id, UpdateBoardDto updateBoardDto);
    BoardDto delete(long id);
}
