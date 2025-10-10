package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.domain.exception.UserNotExistException;
import com.dmgorraiz.task_manager_api.domain.exception.UsernameAlreadyExistsException;
import com.dmgorraiz.task_manager_api.domain.repository.UserRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudUserEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserEntityRepository implements UserRepository {
    private final CrudUserEntity crudUserEntity;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserEntityRepository(CrudUserEntity crudUserEntity, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.crudUserEntity = crudUserEntity;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> getAll() {
        return this.userMapper.toDtos(this.crudUserEntity.findAll());
    }

    @Override
    public UserDto getById(long id) {
        return this.userMapper.toUserDto(this.crudUserEntity.findById(id).orElse(null));
    }

    @Override
    public UserDto getByUsername(String username) {
        return this.userMapper.toUserDto(this.crudUserEntity.findFirstByUsername(username));
    }


    @Override
    public UserDto save(UserDto userDto) {
        if (this.crudUserEntity.findFirstByUsername(userDto.username()) != null) {
            throw new UsernameAlreadyExistsException(userDto.username());
        }

        UserEntity userEntity = this.userMapper.toUserEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userDto.password()));

        return this.userMapper.toUserDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserDto update(long id,UpdateUserDto updateUserDto) {
        UserEntity userEntity = this.crudUserEntity.findById(id).orElse(null);

        if (userEntity == null){
            throw new UserNotExistException(id);
        }

        this.userMapper.updateUserDto(updateUserDto, userEntity);
        userEntity.setPassword(passwordEncoder.encode(updateUserDto.password()));

        return this.userMapper.toUserDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserDto updateByUsername(String username, UpdateUserDto updateUserDto) {
        UserEntity userEntity = this.crudUserEntity.findFirstByUsername(username);

        if (userEntity == null){
            throw new UserNotExistException(userEntity.getId());
        }

        this.userMapper.updateUserDto(updateUserDto, userEntity);
        userEntity.setPassword(passwordEncoder.encode(updateUserDto.password()));

        return this.userMapper.toUserDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserDto delete(long id) {
        UserEntity userEntity = this.crudUserEntity.findById(id)
                .orElseThrow(() -> new UserNotExistException(id));

        UserDto userDto = this.userMapper.toUserDto(userEntity);

        this.crudUserEntity.delete(userEntity);

        return userDto;
    }

    @Override
    public UserDto deleteByUsername(String username) {
        UserEntity userEntity = this.crudUserEntity.findFirstByUsername(username);

        if (userEntity == null){
            throw new UserNotExistException(userEntity.getId());
        }

        this.crudUserEntity.delete(userEntity);

        return this.userMapper.toUserDto(userEntity);
    }
}
