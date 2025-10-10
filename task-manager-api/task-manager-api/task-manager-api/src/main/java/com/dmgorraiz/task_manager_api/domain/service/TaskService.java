package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.TaskDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateTaskDto;
import com.dmgorraiz.task_manager_api.domain.repository.TaskRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudBoardMemberEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CrudBoardMemberEntity crudBoardMemberEntity;

    public TaskService(TaskRepository taskRepository, CrudBoardMemberEntity crudBoardMemberEntity) {
        this.taskRepository = taskRepository;
        this.crudBoardMemberEntity = crudBoardMemberEntity;
    }

    @Secured("ROLE_ADMIN")
    public List<TaskDto> getAll(){
        return taskRepository.getAll();
    }

    public TaskDto getById(long id){
        return taskRepository.getById(id);
    }

    @Tool("Busca las tareas segun el usuario")
    public List<TaskDto> getByUser(String username){
        return taskRepository.getByUser(username);
    }

    public TaskDto save(TaskDto taskDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");
        boolean isManager = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "MANAGER");

        if (!isOwner && !isManager){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }
        return taskRepository.save(taskDto);
    }

    public TaskDto update(long id, UpdateTaskDto updateTaskDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");
        boolean isManager = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "MANAGER");

        if (!isOwner && !isManager){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return taskRepository.update(id, updateTaskDto);
    }

    public TaskDto delete(long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isOwner = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "OWNER");
        boolean isManager = this.crudBoardMemberEntity.existsByUserUsernameAndRoleInBoard(username, "MANAGER");

        if (!isOwner && !isManager){
            throw new AccessDeniedException("You do not have permission to access this resource");
        }

        return taskRepository.delete(id);
    }
}
