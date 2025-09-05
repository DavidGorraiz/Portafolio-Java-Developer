package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "members", target = "membersDto")
    BoardDto toBoadrDto(BoardEntity boardEntity);
    List<BoardDto> toBoadrDtoList(Iterable<BoardEntity> boardEntityList);
}
