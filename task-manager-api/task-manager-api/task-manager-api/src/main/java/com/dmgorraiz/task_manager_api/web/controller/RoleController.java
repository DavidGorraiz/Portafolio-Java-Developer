package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.RoleDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateRoleDto;
import com.dmgorraiz.task_manager_api.domain.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Tag(name = "Roles", description = "Operations about roles")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @Operation(
            summary = "Get all the roles",
            description = "Return a list of all roles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All roles")
            }
    )
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(this.roleService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a role by its id",
            description = "Return a role that has the identifier provided",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Role found"),
                    @ApiResponse(responseCode = "404", description = "Role not found", content = @Content)
            }
    )
    public ResponseEntity<RoleDto> getById(@Parameter(description = "Role's identifier", example = "5") @PathVariable long id) {
        RoleDto roleDto = this.roleService.getById(id);

        if (roleDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(roleDto);
    }

    @PostMapping
    @Operation(
            summary = "Post a new role",
            description = "Create a new role",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Role created"),
                    @ApiResponse(responseCode = "400", description = "Miss the role", content = @Content)
            }
    )
    public ResponseEntity<RoleDto> save(@RequestBody @Valid RoleDto roleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleService.save(roleDto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update a role that already exist",
            description = "Update a role by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Role updated"),
                    @ApiResponse(responseCode = "400", description = "Miss the role", content = @Content)
            }
    )
    public ResponseEntity<RoleDto> update(@Parameter(description = "Role's identifier", example = "5") @PathVariable long id, @RequestBody @Valid UpdateRoleDto updateRoleDto) {
        return ResponseEntity.ok(this.roleService.update(id, updateRoleDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a role that alread exist",
            description = "Delete a role by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Role deleted"),
                    @ApiResponse(responseCode = "400", description = "Id not exists", content = @Content)
            }
    )
    public ResponseEntity<RoleDto> delete(@Parameter(description = "Role's identifier", example = "5") @PathVariable long id) {
        return ResponseEntity.ok(this.roleService.delete(id));
    }
}
