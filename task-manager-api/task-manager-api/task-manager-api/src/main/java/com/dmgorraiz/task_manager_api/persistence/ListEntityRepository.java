package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.repository.ListRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudListEntity;
import com.dmgorraiz.task_manager_api.persistence.mapper.ListMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListEntityRepository implements ListRepository {
    private final CrudListEntity crudListEntity;
    private final ListMapper listMapper;

    public ListEntityRepository(CrudListEntity crudListEntity, ListMapper listMapper) {
        this.crudListEntity = crudListEntity;
        this.listMapper = listMapper;
    }

    @Override
    public List<ListDto> getAll() {
        return this.listMapper.toDtos(this.crudListEntity.findAll());
    }
}
