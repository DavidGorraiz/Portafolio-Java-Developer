package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;

import java.util.List;

public interface UserRepository {
    List<UserDto> getAll();
    UserDto getById(long id);
    UserDto getByUsername(String username);
    UserDto save(UserDto userDto);
    UserDto update(long id,UpdateUserDto updateUserDto);
    UserDto updateByUsername(String username, UpdateUserDto updateUserDto);
    UserDto delete(long id);
    UserDto deleteByUsername(String username);
}
