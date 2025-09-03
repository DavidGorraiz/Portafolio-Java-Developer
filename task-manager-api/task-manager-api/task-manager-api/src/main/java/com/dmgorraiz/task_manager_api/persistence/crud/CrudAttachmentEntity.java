package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudAttachmentEntity extends CrudRepository<AttachmentEntity, Long> {
}
