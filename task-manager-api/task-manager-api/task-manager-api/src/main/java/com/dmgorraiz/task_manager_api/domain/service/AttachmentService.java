package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateAttachmentDto;
import com.dmgorraiz.task_manager_api.domain.repository.AttachmentRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Secured("ROLE_ADMIN")
    public List<AttachmentDto> getAll() {
        return attachmentRepository.getAll();
    }

    public AttachmentDto getById(long id) {
        return attachmentRepository.getById(id);
    }

    public List<AttachmentDto> getByUsername(String username) {
        return attachmentRepository.getByUsername(username);
    }

    public AttachmentDto save(AttachmentDto attachmentDto) {
        return attachmentRepository.save(attachmentDto);
    }

    public AttachmentDto update(long id, UpdateAttachmentDto updateAttachmentDto) {
        return attachmentRepository.update(id, updateAttachmentDto);
    }

    public AttachmentDto delete(long id) {
        return attachmentRepository.delete(id);
    }
}
