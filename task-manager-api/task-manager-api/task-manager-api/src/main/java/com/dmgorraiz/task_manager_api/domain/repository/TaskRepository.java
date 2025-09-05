package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;

import java.util.List;

public interface TaskRepository {
    List<TaskDto> getAll();
}
