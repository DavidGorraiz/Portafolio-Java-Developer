package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateListDto;

import java.util.List;

public interface ListRepository {
    List<ListDto> getAll();
    ListDto getById(long id);
    ListDto save(ListDto listDto);
    ListDto update(long id,UpdateListDto updateListDto);
    ListDto delete(long id);
}
