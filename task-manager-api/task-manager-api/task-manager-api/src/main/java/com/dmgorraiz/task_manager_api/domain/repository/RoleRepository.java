package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;

import java.util.List;

public interface RoleRepository {
    List<RoleDto> getAll();
}
