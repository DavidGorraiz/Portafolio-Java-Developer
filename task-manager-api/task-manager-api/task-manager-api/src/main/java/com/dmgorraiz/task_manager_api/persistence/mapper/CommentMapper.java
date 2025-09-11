package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateCommentDto;
import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto toDto(CommentEntity commentEntity);
    List<CommentDto> toDtos(Iterable<CommentEntity> commentEntities);

    @InheritInverseConfiguration
    CommentEntity toEntity(CommentDto commentDto);

    void updateComment(UpdateCommentDto updateCommentDto, @MappingTarget CommentEntity commentEntity);
}
