package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
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

    public UserDto getById(long id){
        return this.userRepository.getById(id);
    }

    public UserDto save(UserDto userDto){
        return this.userRepository.save(userDto);
    }

    public UserDto update(long id,UpdateUserDto updateUserDto){
        return this.userRepository.update(id, updateUserDto);
    }

    public UserDto delete(long id){
        return this.userRepository.delete(id);
    }
}
