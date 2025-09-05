package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.service.AttachmentService;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudAttachmentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttachmentController {
    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping("/attachments")
    public List<AttachmentDto> getAll() {
        return this.attachmentService.getAll();
    }
}
