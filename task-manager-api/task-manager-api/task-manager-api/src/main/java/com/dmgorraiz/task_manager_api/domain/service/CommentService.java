package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateCommentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.domain.repository.CommentRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    @Secured("ROLE_ADMIN")
    public List<CommentDto> getAll(){
        return commentRepository.getAll();
    }

    public CommentDto getById(long id){
        return commentRepository.getById(id);
    }

    public List<CommentDto> getByUsername(String username){
        return commentRepository.getByUsername(username);
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
