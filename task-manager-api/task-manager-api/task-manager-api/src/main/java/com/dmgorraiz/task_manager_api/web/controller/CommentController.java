package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudCommentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    private final CrudCommentEntity crudCommentEntity;
    public CommentController(CrudCommentEntity crudCommentEntity) {
        this.crudCommentEntity = crudCommentEntity;
    }

    @GetMapping("/comments")
    public List<CommentEntity> getAll(){
        return (List<CommentEntity>) this.crudCommentEntity.findAll();
    }
}
