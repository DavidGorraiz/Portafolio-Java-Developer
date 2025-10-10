package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateCommentDto;

import java.util.List;

public interface CommentRepository {
    List<CommentDto> getAll();
    CommentDto getById(long id);
    List<CommentDto> getByUsername(String username);
    CommentDto save(CommentDto commentDto);
    CommentDto update(long id, UpdateCommentDto updateCommentDto);
    CommentDto delete(long id);
}
