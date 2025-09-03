package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudBoardEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    private final CrudBoardEntity crudBoardEntity;

    public BoardController(CrudBoardEntity crudBoardEntity) {
        this.crudBoardEntity = crudBoardEntity;
    }

    @GetMapping("/boards")
    public List<BoardEntity> getAll() {
        return (List<BoardEntity>) this.crudBoardEntity.findAll();
    }
}
