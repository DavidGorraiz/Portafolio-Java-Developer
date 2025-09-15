package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateListDto;
import com.dmgorraiz.task_manager_api.domain.service.ListService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ListDto> save(@RequestBody @Valid ListDto listDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.listService.save(listDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListDto> update(@PathVariable long id, @RequestBody @Valid UpdateListDto updateListDto) {
        return ResponseEntity.ok(this.listService.update(id, updateListDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListDto> delete(@PathVariable long id) {
        return ResponseEntity.ok(this.listService.delete(id));
    }
}
