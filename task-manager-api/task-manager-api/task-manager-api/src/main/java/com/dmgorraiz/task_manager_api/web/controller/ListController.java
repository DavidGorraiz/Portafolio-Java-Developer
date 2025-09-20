package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.ListDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateListDto;
import com.dmgorraiz.task_manager_api.domain.service.ListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
@Tag(name = "Lists", description = "Operations about lists")
public class ListController {
    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping
    @Operation(
            summary = "Get all the lists",
            description = "Return a list of all the lists in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All lists")
            }
    )
    public ResponseEntity<List<ListDto>> getAll() {
        return ResponseEntity.ok(this.listService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a list by its id",
            description = "Return a list by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List found"),
                    @ApiResponse(responseCode = "404", description = "List not found")
            }
    )
    public ResponseEntity<ListDto> getById(@Parameter(description = "List's identifier", example = "5") @PathVariable long id) {
        ListDto listDto = this.listService.getById(id);

        if (listDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(listDto);
    }

    @PostMapping
    @Operation(
            summary = "Post a new list",
            description = "Return the list created",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List created"),
                    @ApiResponse(responseCode = "400", description = "name and board id is required", content = @Content)
            }
    )
    public ResponseEntity<ListDto> save(@RequestBody @Valid ListDto listDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.listService.save(listDto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update a list that already exist",
            description = "Return the list updated",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List updated"),
                    @ApiResponse(responseCode = "400", description = "Name and board id requiered", content = @Content)
            }
    )
    public ResponseEntity<ListDto> update(@Parameter(description = "List's identifier", example = "5") @PathVariable long id, @RequestBody @Valid UpdateListDto updateListDto) {
        return ResponseEntity.ok(this.listService.update(id, updateListDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a list that already exist",
            description = "Return the list deleted",
            responses = {
                    @ApiResponse(responseCode = "200", description = "LList deleted"),
                    @ApiResponse(responseCode = "400", description = "List not exist", content = @Content)
            }
    )
    public ResponseEntity<ListDto> delete(@Parameter(description = "List's identifier", example = "5") @PathVariable long id) {
        return ResponseEntity.ok(this.listService.delete(id));
    }
}
