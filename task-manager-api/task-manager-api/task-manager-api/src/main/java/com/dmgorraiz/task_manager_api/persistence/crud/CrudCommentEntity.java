package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudCommentEntity extends CrudRepository<CommentEntity, Long> {
    List<CommentEntity> findAllByAuthorUsername(String username);
}
