package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateTaskDto;
import com.dmgorraiz.task_manager_api.domain.service.Asistance;
import com.dmgorraiz.task_manager_api.domain.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks", description = "Operations about tasks")
public class TaskController {
    private final TaskService taskService;
    private final Asistance asistance;

    public TaskController(TaskService taskService, Asistance asistance) {
        this.taskService = taskService;
        this.asistance = asistance;
    }

    @GetMapping
    @Operation(
            summary = "Get all the tasks of all users",
            description = "Return a list of tasks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All tasks found"),
                    @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "User not allowed", content = @Content)
            }
    )
    public ResponseEntity<List<TaskDto>> getAll() {
        return ResponseEntity.ok(this.taskService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a task by its id",
            description = "Return a task depending on its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task found"),
                    @ApiResponse(responseCode = "404", description = "Task not found", content = @Content),
                    @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "User not allowed", content = @Content)
            }
    )
    public ResponseEntity<TaskDto> getById(@Parameter(description = "Task's identifier", example = "5") @PathVariable long id) {
        TaskDto taskDto = this.taskService.getById(id);

        if (taskDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(taskDto);
    }

    @GetMapping("/user")
    @Operation(
            summary = "Get tasks for a user",
            description = "Return a list of tasks that correspond to a user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tasks found"),
                    @ApiResponse(responseCode = "404", description = "Username doesn't have tasks", content = @Content),
                    @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "User not allowed", content = @Content)
            }
    )
    public ResponseEntity<List<TaskDto>> getByUsername() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<TaskDto> tasksDto = this.taskService.getByUser(username);

        if (tasksDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasksDto);
    }

    @GetMapping("/summary")
    @Operation(
            summary = "Get a summary about tasks for a user",
            description = "Return a summary about user's tasks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Summary generated"),
                    @ApiResponse(responseCode = "404", description = "User doesn't have tasks", content = @Content),
                    @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "User not allowed", content = @Content)
            }
    )
    public ResponseEntity<String> getSummary() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        List<TaskDto> tasksDto = this.taskService.getByUser(username);

        if (tasksDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(this.asistance.generateSummary(username));
    }

    @PostMapping
    @Operation(
            summary = "Post a new task",
            description = "Create a new tasks and then return that task",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Task created"),
                    @ApiResponse(responseCode = "400", description = "Task must have title, due date must not be past, task must be in a list and in a board", content = @Content),
                    @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "User not allowed", content = @Content)
            }
    )
    public ResponseEntity<TaskDto> save(@RequestBody @Valid TaskDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.taskService.save(taskDto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update a task that already exist",
            description = "Update a task identified by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task updated"),
                    @ApiResponse(responseCode = "400", description = "Task must have title, due date must not be past, task must be in a list and in a board", content = @Content),
                    @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "User not allowed", content = @Content)
            }
    )
    public ResponseEntity<TaskDto> update(@Parameter(description = "Task's identifier", example = "5") @PathVariable long id, @RequestBody @Valid UpdateTaskDto updateTaskDto) {
        return ResponseEntity.ok(this.taskService.update(id, updateTaskDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a task that already exist",
            description = "Delete a tasks identified by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task deleted"),
                    @ApiResponse(responseCode = "400", description = "Task not exist", content = @Content),
                    @ApiResponse(responseCode = "401", description = "User not authorized", content = @Content),
                    @ApiResponse(responseCode = "403", description = "User not allowed", content = @Content)
            }
    )
    public ResponseEntity<TaskDto> delete(@Parameter(description = "Task's identifier", example = "5") @PathVariable long id){
        return ResponseEntity.ok(this.taskService.delete(id));
    }
}
