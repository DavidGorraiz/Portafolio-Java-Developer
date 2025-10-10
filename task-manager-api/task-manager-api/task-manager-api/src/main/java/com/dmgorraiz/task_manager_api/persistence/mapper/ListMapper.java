package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateListDto;
import com.dmgorraiz.task_manager_api.persistence.entity.ListEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListMapper {

    ListDto toDto(ListEntity listEntity);
    List<ListDto> toDtos(Iterable<ListEntity> listEntities);

    @InheritInverseConfiguration
    ListEntity toEntity(ListDto listDto);

    void updateList(UpdateListDto updateListDto, @MappingTarget ListEntity listEntity);
}
