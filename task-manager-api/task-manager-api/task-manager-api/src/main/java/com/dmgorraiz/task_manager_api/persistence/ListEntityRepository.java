package com.dmgorraiz.task_manager_api.persistence;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateListDto;
import com.dmgorraiz.task_manager_api.domain.repository.ListRepository;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudListEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.ListEntity;
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

    @Override
    public ListDto getById(long id) {
        return this.listMapper.toDto(this.crudListEntity.findById(id).orElse(null));
    }

    @Override
    public ListDto save(ListDto listDto) {
        ListEntity listEntity = this.listMapper.toEntity(listDto);
        return this.listMapper.toDto(this.crudListEntity.save(listEntity));
    }

    @Override
    public ListDto update(long id, UpdateListDto updateListDto) {
        ListEntity listEntity = this.crudListEntity.findById(id).orElse(null);

        if (listEntity == null) return null;

        this.listMapper.updateList(updateListDto, listEntity);

        return this.listMapper.toDto(this.crudListEntity.save(listEntity));
    }

    @Override
    public ListDto delete(long id) {
        ListEntity listEntity = this.crudListEntity.findById(id).orElse(null);

        if (listEntity == null) return null;

        this.crudListEntity.delete(listEntity);

        return this.listMapper.toDto(listEntity);
    }
}
