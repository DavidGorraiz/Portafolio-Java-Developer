package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudUserEntity extends CrudRepository<UserEntity, Long> {
    UserEntity findFirstByUsername(String username);
}
