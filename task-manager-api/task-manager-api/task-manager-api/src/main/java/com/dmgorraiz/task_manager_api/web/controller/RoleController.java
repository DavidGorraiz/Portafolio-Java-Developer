package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.domain.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(this.roleService.getAll());
    }

    @GetMapping("/{role}")
    public ResponseEntity<RoleDto> getById(@PathVariable String role) {
        RoleDto roleDto = this.roleService.getById(role);

        if (roleDto == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(roleDto);
    }
}
