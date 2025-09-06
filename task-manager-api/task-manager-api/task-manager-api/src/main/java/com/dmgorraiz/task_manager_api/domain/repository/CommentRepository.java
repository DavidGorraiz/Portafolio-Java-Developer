package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;

import java.util.List;

public interface CommentRepository {
    List<CommentDto> getAll();
    CommentDto getById(long id);
    CommentDto save(CommentDto commentDto);
}
