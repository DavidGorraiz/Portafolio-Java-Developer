package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fileUrl", target = "fileUrl")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "taskId", target = "taskId")
    AttachmentDto toDto (AttachmentEntity attachmentEntity);
    List<AttachmentDto> toDtos (Iterable<AttachmentEntity> attachmentEntities);
}
