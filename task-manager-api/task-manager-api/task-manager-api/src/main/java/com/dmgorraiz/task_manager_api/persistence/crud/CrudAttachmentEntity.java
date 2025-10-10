package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudAttachmentEntity extends CrudRepository<AttachmentEntity, Long> {
    List<AttachmentEntity> findAllByUserUsername(String username);
}
