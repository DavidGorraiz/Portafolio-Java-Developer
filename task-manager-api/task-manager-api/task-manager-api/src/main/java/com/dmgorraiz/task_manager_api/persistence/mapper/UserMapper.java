package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "locked", target = "locked")
    @Mapping(source = "disabled", target = "disable")
    @Mapping(source = "boards", target = "boardsDto")
    UserDto toUserDto(UserEntity userEntity);
    List<UserDto> toDtos(Iterable<UserEntity> userEntities);
}
