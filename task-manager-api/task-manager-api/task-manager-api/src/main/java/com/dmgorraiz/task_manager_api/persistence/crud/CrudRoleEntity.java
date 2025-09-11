package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudRoleEntity extends CrudRepository<RoleEntity, Long> {
}
