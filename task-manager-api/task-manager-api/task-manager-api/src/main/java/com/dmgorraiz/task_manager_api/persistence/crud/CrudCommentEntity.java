package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudCommentEntity extends CrudRepository<CommentEntity, Long> {
}
