package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "disabled", target = "disable")
    @Mapping(source = "roles", target = "roleDtos")
    UserDto toUserDto(UserEntity userEntity);
    List<UserDto> toDtos(Iterable<UserEntity> userEntities);

    @InheritInverseConfiguration
    UserEntity toUserEntity(UserDto userDto);

    @Mapping(target = "disabled", source = "disable")
    void updateUserDto(UpdateUserDto updateUserDto, @MappingTarget UserEntity userEntity);
}
