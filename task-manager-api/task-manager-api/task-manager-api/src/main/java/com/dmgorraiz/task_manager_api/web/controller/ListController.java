package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudListEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.ListEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {
    private final CrudListEntity crudListEntity;

    public ListController(CrudListEntity crudListEntity) {
        this.crudListEntity = crudListEntity;
    }

    @GetMapping("/lists")
    public List<ListEntity> getAll() {
        return (List<ListEntity>) this.crudListEntity.findAll();
    }
}
