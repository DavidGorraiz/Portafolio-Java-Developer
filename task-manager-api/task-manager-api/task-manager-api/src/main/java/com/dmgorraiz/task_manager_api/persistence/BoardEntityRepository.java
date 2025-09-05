package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.repository.BoardRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudBoardEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.BoardMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardEntityRepository implements BoardRepository {
    private final CrudBoardEntity crudBoardEntity;
    private final BoardMapper boardMapper;

    public BoardEntityRepository(CrudBoardEntity crudBoardEntity, BoardMapper boardMapper) {
        this.crudBoardEntity = crudBoardEntity;
        this.boardMapper = boardMapper;
    }

    @Override
    public List<BoardDto> getAll() {
        return this.boardMapper.toBoadrDtoList(this.crudBoardEntity.findAll());
    }
}
