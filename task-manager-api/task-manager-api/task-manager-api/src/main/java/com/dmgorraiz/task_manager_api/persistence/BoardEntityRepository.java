package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateBoardDto;
import com.dmgorraiz.task_manager_api.domain.exception.IdAlreadyExistsException;
import com.dmgorraiz.task_manager_api.domain.exception.IdNotExistException;
import com.dmgorraiz.task_manager_api.domain.repository.BoardRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudBoardEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
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

    @Override
    public BoardDto getById(long id) {
        return this.boardMapper.toBoadrDto(this.crudBoardEntity.findById(id).orElse(null));
    }

    @Override
    public List<BoardDto> getByOwner(String owner) {
        return this.boardMapper.toBoadrDtoList(this.crudBoardEntity.findByOwnerUsername(owner));
    }

    @Override
    public List<BoardDto> getByMember(String member) {
        return this.boardMapper.toBoadrDtoList(this.crudBoardEntity.findAllByMembersUserUsername(member));
    }

    @Override
    public BoardDto save(BoardDto boardDto) {
        BoardEntity boardEntity = this.boardMapper.toBoardEntity(boardDto);

        return this.boardMapper.toBoadrDto(this.crudBoardEntity.save(boardEntity));
    }

    @Override
    public BoardDto update(long id, UpdateBoardDto updateBoardDto) {
        BoardEntity boardEntity = this.crudBoardEntity.findById(id).orElse(null);

        if (boardEntity == null){
            throw new IdNotExistException(id);
        }

        this.boardMapper.updateBoard(updateBoardDto, boardEntity);

        return this.boardMapper.toBoadrDto(this.crudBoardEntity.save(boardEntity));
    }

    @Override
    public BoardDto delete(long id) {
        BoardEntity boardEntity = this.crudBoardEntity.findById(id).orElse(null);

        if (boardEntity == null) {
            throw new IdNotExistException(id);
        }

        this.crudBoardEntity.delete(boardEntity);

        return this.boardMapper.toBoadrDto(boardEntity);
    }
}
