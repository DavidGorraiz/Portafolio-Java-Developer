package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateTaskDto;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "attachments", target = "attachmentDtos")
    @Mapping(source = "comments", target = "commentDtos")
    TaskDto toDto(TaskEntity taskEntity);
    List<TaskDto> toDtos(Iterable<TaskEntity> taskEntities);

    @InheritInverseConfiguration
    TaskEntity toEntity(TaskDto taskDto);

    void updateTask(UpdateTaskDto updateTaskDto, @MappingTarget TaskEntity taskEntity);
}
