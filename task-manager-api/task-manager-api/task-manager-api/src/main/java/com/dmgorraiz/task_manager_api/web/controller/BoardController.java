package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateBoardDto;
import com.dmgorraiz.task_manager_api.domain.service.BoardService;
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
@RequestMapping("/boards")
@Tag(name = "Boards", description = "Operations about boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    @Operation(
            summary = "Get all the boards",
            description = "Return a list of all boards in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All boards")
            }
    )
    public ResponseEntity<List<BoardDto>> getAll() {
        return ResponseEntity.ok(this.boardService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a board by its id",
            description = "Return a board if the id exist in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Board found"),
                    @ApiResponse(responseCode = "404", description = "Board not found", content = @Content)
            }
    )
    public ResponseEntity<BoardDto> getById(@Parameter(description = "Board's identifier", example = "5") @PathVariable long id) {
        BoardDto boardDto = this.boardService.getById(id);

        if (boardDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(boardDto);
    }

    @PostMapping
    @Operation(
            summary = "Post a new board",
            description = "Create a board in the database",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Board created"),
                    @ApiResponse(responseCode = "400", description = "Name is required", content = @Content)
            }
    )
    public ResponseEntity<BoardDto> save(@RequestBody @Valid BoardDto boardDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.boardService.save(boardDto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update a board that already exist",
            description = "Return the board updated",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Board updated"),
                    @ApiResponse(responseCode = "400", description = "Name is required or the board not exist", content = @Content)
            }
    )
    public ResponseEntity<BoardDto> update(@Parameter(description = "Board's identifier", example = "5") @PathVariable long id ,@RequestBody @Valid UpdateBoardDto updateBoardDto) {
        return ResponseEntity.ok(this.boardService.update(id, updateBoardDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a board that already exist",
            description = "Return the board deleted",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Board deleted"),
                    @ApiResponse(responseCode = "400", description = "Board not exist", content = @Content)
            }
    )
    public ResponseEntity<BoardDto> delete(@Parameter(description = "Board's identifier", example = "5") @PathVariable long id){
        return ResponseEntity.ok(this.boardService.delete(id));
    }
}
