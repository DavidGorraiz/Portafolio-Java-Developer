package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.persistence.entity.ListEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "position", target = "position")
    @Mapping(source = "boardId", target = "boardId")
    @Mapping(source = "tasks", target = "tasksDto")
    ListDto toDto(ListEntity listEntity);
    List<ListDto> toDtos(Iterable<ListEntity> listEntities);
}
