package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudBoardEntity extends CrudRepository<BoardEntity, Long> {
}
