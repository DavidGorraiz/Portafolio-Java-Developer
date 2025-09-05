package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "taskId", target = "taskId")
    CommentDto toDto(CommentEntity commentEntity);
    List<CommentDto> toDtos(Iterable<CommentEntity> commentEntities);

}
