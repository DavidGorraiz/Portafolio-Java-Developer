package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
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

    public RoleDto getById(String role){
        return roleRepository.getById(role);
    }

    public RoleDto save(RoleDto roleDto){
        return roleRepository.save(roleDto);
    }
}
