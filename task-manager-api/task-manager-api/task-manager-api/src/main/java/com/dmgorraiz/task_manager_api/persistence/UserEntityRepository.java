package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.UpdateUserDto;
import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
import com.dmgorraiz.task_manager_api.domain.exception.UserNotExistException;
import com.dmgorraiz.task_manager_api.domain.exception.UsernameAlreadyExistsException;
import com.dmgorraiz.task_manager_api.domain.repository.UserRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudUserEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserEntityRepository implements UserRepository {
    private final CrudUserEntity crudUserEntity;
    private final UserMapper userMapper;

    public UserEntityRepository(CrudUserEntity crudUserEntity, UserMapper userMapper) {
        this.crudUserEntity = crudUserEntity;
        this.userMapper = userMapper;
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
    public UserDto save(UserDto userDto) {
        if (this.crudUserEntity.findFirstByUsername(userDto.username()) != null) {
            throw new UsernameAlreadyExistsException(userDto.username());
        }

        UserEntity userEntity = this.userMapper.toUserEntity(userDto);

        return this.userMapper.toUserDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserDto update(long id,UpdateUserDto updateUserDto) {
        UserEntity userEntity = this.crudUserEntity.findById(id).orElse(null);

        if (userEntity == null){
            throw new UserNotExistException(id);
        }

        this.userMapper.updateUserDto(updateUserDto, userEntity);

        return this.userMapper.toUserDto(this.crudUserEntity.save(userEntity));
    }

    @Override
    public UserDto delete(long id) {
        UserEntity userEntity = this.crudUserEntity.findById(id).orElse(null);

        if (userEntity == null) {
            throw new UserNotExistException(id);
        }

        this.crudUserEntity.delete(userEntity);

        return this.userMapper.toUserDto(userEntity);
    }
}
