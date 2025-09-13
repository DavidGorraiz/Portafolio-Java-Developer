package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateAttachmentDto;
import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {

    AttachmentDto toDto (AttachmentEntity attachmentEntity);
    List<AttachmentDto> toDtos (Iterable<AttachmentEntity> attachmentEntities);

    @InheritInverseConfiguration
    AttachmentEntity toEntity (AttachmentDto attachmentDto);

    void updateAttachment(UpdateAttachmentDto updateAttachmentDto, @MappingTarget AttachmentEntity attachmentEntity);
}
