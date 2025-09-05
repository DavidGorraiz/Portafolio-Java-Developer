package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "dueDate", target = "dueDate")
    @Mapping(source = "position", target = "position")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "listId", target = "listId")
    @Mapping(source = "boardId", target = "boardId")
    @Mapping(source = "attachments", target = "attachmentDtos")
    @Mapping(source = "comments", target = "commentDtos")
    TaskDto toDto(TaskEntity taskEntity);
    List<TaskDto> toDtos(Iterable<TaskEntity> taskEntities);
}
