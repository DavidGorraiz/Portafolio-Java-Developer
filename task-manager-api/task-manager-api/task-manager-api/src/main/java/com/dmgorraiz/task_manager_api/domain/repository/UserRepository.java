package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;

import java.util.List;

public interface UserRepository {
    List<UserDto> getAll();
    UserDto getById(long id);
    UserDto save(UserDto userDto);
    UserDto update(long id,UpdateUserDto updateUserDto);
    UserDto delete(long id);
}
