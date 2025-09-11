package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateAttachmentDto;

import java.util.List;

public interface AttachmentRepository {
    List<AttachmentDto> getAll();
    AttachmentDto getById(long id);
    AttachmentDto save(AttachmentDto attachmentDto);
    AttachmentDto update(long id, UpdateAttachmentDto updateAttachmentDto);
    AttachmentDto delete(long id);
}
