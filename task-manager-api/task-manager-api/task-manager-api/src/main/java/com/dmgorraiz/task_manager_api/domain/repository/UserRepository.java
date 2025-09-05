package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.UserDto;

import java.util.List;

public interface UserRepository {
    List<UserDto> getAll();
    UserDto getById(String username);
}
