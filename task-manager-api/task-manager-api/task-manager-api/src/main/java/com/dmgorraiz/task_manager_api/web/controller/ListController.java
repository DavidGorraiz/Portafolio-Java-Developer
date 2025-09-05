package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.service.ListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController {
    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping
    public ResponseEntity<List<ListDto>> getAll() {
        return ResponseEntity.ok(this.listService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListDto> getById(@PathVariable long id) {
        ListDto listDto = this.listService.getById(id);

        if (listDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(listDto);
    }
}
