package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
    private final ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public List<ListDto> getAll(){
        return listRepository.getAll();
    }

    public ListDto getById(long id){
        return listRepository.getById(id);
    }

    public ListDto save(ListDto listDto){
        return listRepository.save(listDto);
    }
}
