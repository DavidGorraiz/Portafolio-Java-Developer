package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.domain.dto.BoardDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateBoardDto;
import com.dmgorraiz.task_manager_api.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardDto> getAll(){
        return this.boardRepository.getAll();
    }

    public BoardDto getById(long id){
        return this.boardRepository.getById(id);
    }

    public BoardDto save(BoardDto boardDto){
        return this.boardRepository.save(boardDto);
    }

    public BoardDto update(long id, UpdateBoardDto updateBoardDto){
        return this.boardRepository.update(id, updateBoardDto);
    }

    public BoardDto delete(long id){
        return this.boardRepository.delete(id);
    }
}
