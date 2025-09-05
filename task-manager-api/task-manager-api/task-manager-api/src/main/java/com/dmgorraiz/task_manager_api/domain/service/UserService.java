package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAll(){
        return this.userRepository.getAll();
    }
}
