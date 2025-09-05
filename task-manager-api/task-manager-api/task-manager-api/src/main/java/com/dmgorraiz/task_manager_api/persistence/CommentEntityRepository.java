package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.repository.CommentRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudCommentEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.CommentMapper;
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
}
