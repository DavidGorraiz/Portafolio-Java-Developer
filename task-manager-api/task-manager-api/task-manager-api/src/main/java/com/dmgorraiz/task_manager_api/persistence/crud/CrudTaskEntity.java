package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudTaskEntity extends CrudRepository<TaskEntity, Long> {
}
