package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.domain.service.UserService;
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
@RequestMapping("/users")
@Tag(name = "Users", description = "Operations about users of TaskAPI")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(
            summary = "Get all the users",
            description = "Return the list of all users",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Users found")
            }
    )
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a user by its id",
            description = "Return a user that match with the provided id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found"),
                    @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
            }
    )
    public ResponseEntity<UserDto> getById(@Parameter(description = "User's identifier", example = "9") @PathVariable long id) {
        UserDto userDto = this.userService.getById(id);

        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    @Operation(
            summary = "Post a user with a username and a password",
            description = "Insert a new user and return the user created",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User created"),
                    @ApiResponse(responseCode = "400", description = "Miss the username or the password", content = @Content)
            }
    )
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(userDto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update a user, you can change username, password, and change if it is locked or disabled",
            description = "Update a user providing the id and in the body the data you want to update",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User updated"),
                    @ApiResponse(responseCode = "400", description = "Miss the username or the password", content = @Content)
            }
    )
    public ResponseEntity<UserDto> update(@Parameter(description = "User's identifier", example = "5") @PathVariable long id,@RequestBody @Valid UpdateUserDto updateUserDto) {
        return ResponseEntity.ok(this.userService.update(id,updateUserDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a user by its id",
            description = "Delete a user and return the data of the user deleted",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User Deleted"),
                    @ApiResponse(responseCode = "400", description = "The user you want delete don't exists", content = @Content)
            }
    )
    public ResponseEntity<UserDto> delete(@Parameter(description = "User's identifier", example = "5") @PathVariable long id) {
        return ResponseEntity.ok(this.userService.delete(id));
    }
}
