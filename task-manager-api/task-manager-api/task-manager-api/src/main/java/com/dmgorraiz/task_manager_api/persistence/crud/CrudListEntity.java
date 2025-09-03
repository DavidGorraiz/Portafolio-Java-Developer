package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.ListEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudListEntity extends CrudRepository<ListEntity, Long> {
}
