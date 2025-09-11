package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateTaskDto;
import com.dmgorraiz.task_manager_api.domain.repository.TaskRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudTaskEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.TaskMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskEntityRepository implements TaskRepository {
    private final CrudTaskEntity crudTaskEntity;
    private final TaskMapper taskMapper;

    public TaskEntityRepository(CrudTaskEntity crudTaskEntity, TaskMapper taskMapper) {
        this.crudTaskEntity = crudTaskEntity;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDto> getAll() {
        return this.taskMapper.toDtos(this.crudTaskEntity.findAll());
    }

    @Override
    public TaskDto getById(long id) {
        return this.taskMapper.toDto(this.crudTaskEntity.findById(id).orElse(null));
    }

    @Override
    public List<TaskDto> getByUser(String username) {
        return this.taskMapper.toDtos(this.crudTaskEntity.findTasksByUsername(username));
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        TaskEntity taskEntity = this.taskMapper.toEntity(taskDto);
        return this.taskMapper.toDto(this.crudTaskEntity.save(taskEntity));
    }

    @Override
    public TaskDto update(long id, UpdateTaskDto updateTaskDto) {
        TaskEntity taskEntity = this.crudTaskEntity.findById(id).orElse(null);

        if (taskEntity == null) return null;

        this.taskMapper.updateTask(updateTaskDto, taskEntity);

        return this.taskMapper.toDto(this.crudTaskEntity.save(taskEntity));
    }

    @Override
    public TaskDto delete(long id) {
        TaskEntity taskEntity = this.crudTaskEntity.findById(id).orElse(null);

        if (taskEntity == null) return null;

        this.crudTaskEntity.delete(taskEntity);

        return this.taskMapper.toDto(taskEntity);
    }
}
