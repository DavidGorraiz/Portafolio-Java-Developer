package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.ListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudListEntity extends CrudRepository<ListEntity, Long> {
    List<ListEntity> findAllByBoardOwnerUsername(String username);
}
