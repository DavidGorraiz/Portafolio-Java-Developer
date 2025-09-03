package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudUserEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final CrudUserEntity crudUserEntity;

    public UserController(CrudUserEntity crudUserEntity) {
        this.crudUserEntity = crudUserEntity;
    }

    @GetMapping("/users")
    public List<UserEntity> getAll() {
        return (List<UserEntity>) this.crudUserEntity.findAll();
    }
}
