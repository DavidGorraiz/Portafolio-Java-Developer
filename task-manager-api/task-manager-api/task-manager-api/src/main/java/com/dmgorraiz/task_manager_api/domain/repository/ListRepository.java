package com.dmgorraiz.task_manager_api.domain.repository;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;

import java.util.List;

public interface ListRepository {
    List<ListDto> getAll();
}
