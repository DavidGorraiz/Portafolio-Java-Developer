package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateBoardDto;
import com.dmgorraiz.task_manager_api.domain.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<BoardDto>> getAll() {
        return ResponseEntity.ok(this.boardService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> getById(@PathVariable long id) {
        BoardDto boardDto = this.boardService.getById(id);

        if (boardDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(boardDto);
    }

    @PostMapping
    public ResponseEntity<BoardDto> save(@RequestBody BoardDto boardDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.boardService.save(boardDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDto> update(@PathVariable long id ,@RequestBody UpdateBoardDto updateBoardDto) {
        return ResponseEntity.ok(this.boardService.update(id, updateBoardDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BoardDto> delete(@PathVariable long id){
        return ResponseEntity.ok(this.boardService.delete(id));
    }
}
