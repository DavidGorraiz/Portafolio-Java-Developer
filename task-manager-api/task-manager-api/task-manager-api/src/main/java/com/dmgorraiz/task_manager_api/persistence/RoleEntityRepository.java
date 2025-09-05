package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.domain.repository.RoleRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudRoleEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.RoleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleEntityRepository implements RoleRepository {

    private final CrudRoleEntity crudRoleEntity;
    private final RoleMapper roleMapper;

    public RoleEntityRepository(CrudRoleEntity crudRoleEntity, RoleMapper roleMapper) {
        this.crudRoleEntity = crudRoleEntity;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDto> getAll() {
        return this.roleMapper.toDtos(this.crudRoleEntity.findAll());
    }
}
