package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateListDto;
import com.dmgorraiz.task_manager_api.domain.repository.ListRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudBoardMemberEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    private final ListRepository listRepository;
    private final CrudBoardMemberEntity crudBoardMemberEntity;

    public ListService(ListRepository listRepository, CrudBoardMemberEntity crudBoardMemberEntity) {
        this.listRepository = listRepository;
        this.crudBoardMemberEntity = crudBoardMemberEntity;
    }

    @Secured("ROLE_ADMIN")
    public List<ListDto> getAll(){
        return listRepository.getAll();
    }

    public ListDto getById(long id){
        return listRepository.getById(id);
    }

    public List<ListDto> getByUsername(String username){
        return listRepository.getByUsername(username);
    }

    public ListDto save(ListDto listDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");
        boolean isManager = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "MANAGER");

        if (!isOwner && !isManager){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return listRepository.save(listDto);
    }

    public  ListDto update(long id, UpdateListDto updateListDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");
        boolean isManager = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "MANAGER");

        if (!isOwner && !isManager){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return listRepository.update(id, updateListDto);
    }

    public ListDto delete(long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");

        if (!isOwner){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return listRepository.delete(id);
    }
}
