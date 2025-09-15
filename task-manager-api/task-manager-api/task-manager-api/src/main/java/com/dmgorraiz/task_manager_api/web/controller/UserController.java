package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id) {
        UserDto userDto = this.userService.getById(id);

        if (userDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable long id,@RequestBody @Valid UpdateUserDto updateUserDto) {
        return ResponseEntity.ok(this.userService.update(id,updateUserDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable long id) {
        return ResponseEntity.ok(this.userService.delete(id));
    }
}
