package com.dmgorraiz.task_manager_api.persistence.mapper;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateBoardDto;
import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    @Mapping(source = "members", target = "membersDto")
    BoardDto toBoadrDto(BoardEntity boardEntity);
    List<BoardDto> toBoadrDtoList(Iterable<BoardEntity> boardEntityList);

    @InheritInverseConfiguration
    BoardEntity toBoardEntity(BoardDto boardDto);

    void updateBoard(UpdateBoardDto updateBoardDto, @MappingTarget BoardEntity boardEntity);
}
