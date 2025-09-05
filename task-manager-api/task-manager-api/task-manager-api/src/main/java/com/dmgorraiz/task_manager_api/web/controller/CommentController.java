package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAll(){
        return ResponseEntity.ok(this.commentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getById(@PathVariable long id){
        CommentDto commentDto = this.commentService.getById(id);

        if(commentDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(commentDto);
    }
}
