package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateTaskDto;
import com.dmgorraiz.task_manager_api.domain.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<TaskDto> save(@RequestBody TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.taskService.save(taskDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable long id, @RequestBody UpdateTaskDto updateTaskDto) {
        return ResponseEntity.ok(this.taskService.update(id, updateTaskDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> delete(@PathVariable long id){
        return ResponseEntity.ok(this.taskService.delete(id));
    }
}
