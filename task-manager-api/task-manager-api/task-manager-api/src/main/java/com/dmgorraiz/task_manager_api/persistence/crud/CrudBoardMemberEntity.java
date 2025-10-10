package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.BoardMemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudBoardMemberEntity extends CrudRepository<BoardMemberEntity, Long> {
    boolean existsByUserUsernameAndRoleInBoard(String username, String role);
}
