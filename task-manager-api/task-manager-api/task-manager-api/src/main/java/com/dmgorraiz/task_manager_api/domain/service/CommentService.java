package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateCommentDto;
import com.dmgorraiz.task_manager_api.domain.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDto> getAll(){
        return commentRepository.getAll();
    }

    public CommentDto getById(long id){
        return commentRepository.getById(id);
    }

    public CommentDto save(CommentDto commentDto){
        return commentRepository.save(commentDto);
    }

    public CommentDto update(long id, UpdateCommentDto updateCommentDto){
        return commentRepository.update(id, updateCommentDto);
    }

    public CommentDto delete(long id){
        return commentRepository.delete(id);
    }
}
