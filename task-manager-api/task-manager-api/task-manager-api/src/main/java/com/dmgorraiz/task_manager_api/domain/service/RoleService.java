package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateRoleDto;
import com.dmgorraiz.task_manager_api.domain.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> getAll(){
        return roleRepository.getAll();
    }

    public RoleDto getById(long id){
        return roleRepository.getById(id);
    }

    public RoleDto save(RoleDto roleDto){
        return roleRepository.save(roleDto);
    }

    public RoleDto update(long id,UpdateRoleDto updateRoleDto){
        return roleRepository.update(id, updateRoleDto);
    }

    public RoleDto delete(long id){
        return roleRepository.delete(id);
    }
}
