package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudRoleEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.RoleEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    private final CrudRoleEntity crudRoleEntity;

    public RoleController(CrudRoleEntity crudRoleEntity) {
        this.crudRoleEntity = crudRoleEntity;
    }

    @GetMapping("/roles")
    public List<RoleEntity> getAll() {
        return (List<RoleEntity>) this.crudRoleEntity.findAll();
    }
}
