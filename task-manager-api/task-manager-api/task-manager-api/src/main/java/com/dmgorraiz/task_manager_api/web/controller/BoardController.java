package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
