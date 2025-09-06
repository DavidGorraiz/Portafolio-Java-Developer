package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.UserDto;
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
    public UserDto getById(String username) {
        return this.userMapper.toUserDto(this.crudUserEntity.findById(username).orElse(null));
    }

    @Override
    public UserDto save(UserDto userDto) {
        UserEntity userEntity = this.userMapper.toUserEntity(userDto);

        return this.userMapper.toUserDto(this.crudUserEntity.save(userEntity));
    }
}
