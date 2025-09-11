package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateTaskDto;

import java.util.List;

public interface TaskRepository {
    List<TaskDto> getAll();
    TaskDto getById(long id);
    List<TaskDto> getByUser(String username);
    TaskDto save(TaskDto taskDto);
    TaskDto update(long id, UpdateTaskDto updateTaskDto);
    TaskDto delete(long id);
}
