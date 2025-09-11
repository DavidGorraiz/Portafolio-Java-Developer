package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateRoleDto;

import java.util.List;

public interface RoleRepository {
    List<RoleDto> getAll();
    RoleDto getById(long id);
    RoleDto save(RoleDto role);
    RoleDto update(long id,UpdateRoleDto updateRoleDto);
    RoleDto delete(long id);
}
