package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateCommentDto;
import com.dmgorraiz.task_manager_api.domain.exception.IdAlreadyExistsException;
import com.dmgorraiz.task_manager_api.domain.exception.IdNotExistException;
import com.dmgorraiz.task_manager_api.domain.repository.CommentRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudCommentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.CommentMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentEntityRepository implements CommentRepository {
    private final CrudCommentEntity crudCommentEntity;
    private final CommentMapper commentMapper;

    public CommentEntityRepository(CrudCommentEntity crudCommentEntity, CommentMapper commentMapper) {
        this.crudCommentEntity = crudCommentEntity;
        this.commentMapper = commentMapper;
    }


    @Override
    public List<CommentDto> getAll() {
        return this.commentMapper.toDtos(this.crudCommentEntity.findAll());

    }

    @Override
    public CommentDto getById(long id) {
        return this.commentMapper.toDto(this.crudCommentEntity.findById(id).orElse(null));
    }

    @Override
    public List<CommentDto> getByUsername(String username) {
        return this.commentMapper.toDtos(this.crudCommentEntity.findAllByAuthorUsername(username));
    }

    @Override
    public CommentDto save(CommentDto commentDto) {
        CommentEntity commentEntity = this.commentMapper.toEntity(commentDto);

        return this.commentMapper.toDto(this.crudCommentEntity.save(commentEntity));
    }

    @Override
    public CommentDto update(long id, UpdateCommentDto updateCommentDto) {
        CommentEntity commentEntity = this.crudCommentEntity.findById(id).orElse(null);

        if (commentEntity == null) {
            throw new IdNotExistException(id);
        }

        this.commentMapper.updateComment(updateCommentDto, commentEntity);

        return this.commentMapper.toDto(this.crudCommentEntity.save(commentEntity));
    }

    @Override
    public CommentDto delete(long id) {
        CommentEntity commentEntity = this.crudCommentEntity.findById(id).orElse(null);

        if (commentEntity == null) {
            throw new IdNotExistException(id);
        }

        this.crudCommentEntity.delete(commentEntity);

        return this.commentMapper.toDto(commentEntity);
    }
}
