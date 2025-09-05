package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.service.CommentService;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudCommentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public List<CommentDto> getAll(){
        return this.commentService.getAll();
    }
}
