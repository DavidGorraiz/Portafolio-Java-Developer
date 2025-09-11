package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateTaskDto;
import com.dmgorraiz.task_manager_api.domain.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDto> getAll(){
        return taskRepository.getAll();
    }

    public TaskDto getById(long id){
        return taskRepository.getById(id);
    }

    public TaskDto save(TaskDto taskDto){
        return taskRepository.save(taskDto);
    }

    public TaskDto update(long id, UpdateTaskDto updateTaskDto){
        return taskRepository.update(id, updateTaskDto);
    }

    public TaskDto delete(long id){
        return taskRepository.delete(id);
    }
}
