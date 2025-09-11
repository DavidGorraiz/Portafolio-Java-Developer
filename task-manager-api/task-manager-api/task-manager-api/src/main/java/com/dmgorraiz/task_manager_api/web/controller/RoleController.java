package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateRoleDto;
import com.dmgorraiz.task_manager_api.domain.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getById(@PathVariable long id) {
        RoleDto roleDto = this.roleService.getById(id);

        if (roleDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(roleDto);
    }

    @PostMapping
    public ResponseEntity<RoleDto> save(@RequestBody RoleDto roleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleService.save(roleDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> update(@PathVariable long id, @RequestBody UpdateRoleDto updateRoleDto) {
        return ResponseEntity.ok(this.roleService.update(id, updateRoleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleDto> delete(@PathVariable long id) {
        return ResponseEntity.ok(this.roleService.delete(id));
    }
}
