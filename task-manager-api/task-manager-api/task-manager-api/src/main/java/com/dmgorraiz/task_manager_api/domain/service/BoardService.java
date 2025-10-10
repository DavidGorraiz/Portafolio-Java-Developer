package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateBoardDto;
import com.dmgorraiz.task_manager_api.domain.repository.BoardRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudBoardMemberEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CrudBoardMemberEntity crudBoardMemberEntity;

    public BoardService(BoardRepository boardRepository, CrudBoardMemberEntity crudBoardMemberEntity) {
        this.boardRepository = boardRepository;
        this.crudBoardMemberEntity = crudBoardMemberEntity;
    }

    @Secured("ROLE_ADMIN")
    public List<BoardDto> getAll(){
        return this.boardRepository.getAll();
    }

    public BoardDto getById(long id){
        return this.boardRepository.getById(id);
    }

    public List<BoardDto> getByOwner(String owner){
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(owner, "OWNER");

        if (!isOwner){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return this.boardRepository.getByOwner(owner);
    }

    public List<BoardDto> getByMember(String member){
        return this.boardRepository.getByMember(member);
    }

    public BoardDto save(BoardDto boardDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");
        boolean isManager = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "MANAGER");

        if (!isOwner && !isManager){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return this.boardRepository.save(boardDto);
    }

    public BoardDto update(long id, UpdateBoardDto updateBoardDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");
        boolean isManager = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "MANAGER");


        if (!isOwner && !isManager){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return this.boardRepository.update(id, updateBoardDto);
    }

    public BoardDto delete(long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");


        if (!isOwner){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return this.boardRepository.delete(id);
    }
}
