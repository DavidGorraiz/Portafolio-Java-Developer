package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateRoleDto;
import com.dmgorraiz.task_manager_api.domain.repository.RoleRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudRoleEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.RoleEntity;
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

    @Override
    public RoleDto getById(long id) {
        return this.roleMapper.toDto(this.crudRoleEntity.findById(id).orElse(null));
    }

    @Override
    public RoleDto save(RoleDto role) {
        RoleEntity roleEntity = this.roleMapper.toEntity(role);
        return this.roleMapper.toDto(this.crudRoleEntity.save(roleEntity));
    }

    @Override
    public RoleDto update(long id, UpdateRoleDto updateRoleDto) {
        RoleEntity roleEntity = this.crudRoleEntity.findById(id).orElse(null);

        if (roleEntity == null) return null;

        this.roleMapper.updateRole(updateRoleDto, roleEntity);

        return this.roleMapper.toDto(this.crudRoleEntity.save(roleEntity));
    }

    @Override
    public RoleDto delete(long id) {
        RoleEntity roleEntity = this.crudRoleEntity.findById(id).orElse(null);

        if (roleEntity == null) return null;

        this.crudRoleEntity.delete(roleEntity);

        return this.roleMapper.toDto(roleEntity);
    }
}
