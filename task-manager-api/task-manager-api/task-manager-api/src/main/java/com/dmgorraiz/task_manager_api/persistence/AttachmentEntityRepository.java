package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.repository.AttachmentRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudAttachmentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.AttachmentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttachmentEntityRepository implements AttachmentRepository {
    private final CrudAttachmentEntity crudAttachmentEntity;
    private final AttachmentMapper attachmentMapper;

    public AttachmentEntityRepository(CrudAttachmentEntity crudAttachmentEntity, AttachmentMapper attachmentMapper) {
        this.crudAttachmentEntity = crudAttachmentEntity;
        this.attachmentMapper = attachmentMapper;
    }

    @Override
    public List<AttachmentDto> getAll() {
        return this.attachmentMapper.toDtos(this.crudAttachmentEntity.findAll());
    }

    @Override
    public AttachmentDto getById(long id) {
        return this.attachmentMapper.toDto(this.crudAttachmentEntity.findById(id).orElse(null));
    }

    @Override
    public AttachmentDto save(AttachmentDto attachmentDto) {
        AttachmentEntity attachmentEntity = this.attachmentMapper.toEntity(attachmentDto);
        return this.attachmentMapper.toDto(this.crudAttachmentEntity.save(attachmentEntity));
    }
}
