package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudAttachmentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttachmentController {
    private final CrudAttachmentEntity crudAttachmentEntity;

    public AttachmentController(CrudAttachmentEntity crudAttachmentEntity) {
        this.crudAttachmentEntity = crudAttachmentEntity;
    }

    @GetMapping("/attachments")
    public List<AttachmentEntity> getAll() {
        return (List<AttachmentEntity>) this.crudAttachmentEntity.findAll();
    }
}
