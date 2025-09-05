package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll() {
        return ResponseEntity.ok(this.taskService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable long id) {
        TaskDto taskDto = this.taskService.getById(id);

        if (taskDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(taskDto);
    }
}
