package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.domain.repository.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Secured("ROLE_ADMIN")
    public List<UserDto> getAll(){
        return this.userRepository.getAll();
    }

    @Secured("ROLE_ADMIN")
    public UserDto getById(long id){
        return this.userRepository.getById(id);
    }

    @Secured("ROLE_READER")
    public UserDto getByUsername(String username){
        return this.userRepository.getByUsername(username);
    }

    public UserDto save(UserDto userDto){
        return this.userRepository.save(userDto);
    }

    @Secured("ROLE_ADMIN")
    public UserDto update(long id,UpdateUserDto updateUserDto){
        return this.userRepository.update(id, updateUserDto);
    }

    @Secured("ROLE_READER")
    public UserDto updateByUsername(String username, UpdateUserDto updateUserDto){
        return this.userRepository.updateByUsername(username, updateUserDto);
    }

    @Secured("ROLE_ADMIN")
    public UserDto delete(long id){
        return this.userRepository.delete(id);
    }

    @Secured("ROLE_READER")
    public UserDto deleteByUsername(String username){
        return this.userRepository.deleteByUsername(username);
    }
}
