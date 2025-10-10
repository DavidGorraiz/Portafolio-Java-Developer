package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudBoardEntity extends CrudRepository<BoardEntity, Long> {
    List<BoardEntity> findByOwnerUsername(String owner);
    List<BoardEntity> findAllByMembersUserUsername(String membersUsername);
}
