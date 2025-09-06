package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
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
    public TaskDto save(TaskDto taskDto) {
        TaskEntity taskEntity = this.taskMapper.toEntity(taskDto);
        return this.taskMapper.toDto(this.crudTaskEntity.save(taskEntity));
    }
}
