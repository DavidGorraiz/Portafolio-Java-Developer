package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.repository.AttachmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public List<AttachmentDto> getAll() {
        return attachmentRepository.getAll();
    }
}
