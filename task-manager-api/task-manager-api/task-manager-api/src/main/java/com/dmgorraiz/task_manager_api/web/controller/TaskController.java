package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudTaskEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final CrudTaskEntity crudTaskEntity;

    public TaskController(CrudTaskEntity crudTaskEntity) {
        this.crudTaskEntity = crudTaskEntity;
    }

    @GetMapping("/tasks")
    public List<TaskEntity> getAll() {
        return (List<TaskEntity>) this.crudTaskEntity.findAll();
    }
}
