package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.persistence.entity.RoleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(source = "users", target = "usersDto")
    RoleDto toDto(RoleEntity roleEntity);
    List<RoleDto> toDtos(Iterable<RoleEntity> roleEntities);

    @InheritInverseConfiguration
    RoleEntity toEntity(RoleDto roleDto);
}
