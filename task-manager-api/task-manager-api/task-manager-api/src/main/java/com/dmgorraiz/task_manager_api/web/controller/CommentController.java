package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.CommentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateCommentDto;
import com.dmgorraiz.task_manager_api.domain.service.CommentService;
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
@RequestMapping("/comments")
@Tag(name = "Comments", description = "Operations about comments")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @Operation(
            summary = "Get all the comments in the database",
            description = "Return a list of all the comments",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All comments")
            }
    )
    public ResponseEntity<List<CommentDto>> getAll(){
        return ResponseEntity.ok(this.commentService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a comment",
            description = "Return a comment by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Comment found"),
                    @ApiResponse(responseCode = "404", description = "Comment not found", content = @Content)
            }
    )
    public ResponseEntity<CommentDto> getById(@Parameter(description = "Comment's identifier", example = "5") @PathVariable long id){
        CommentDto commentDto = this.commentService.getById(id);

        if(commentDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(commentDto);
    }

    @PostMapping
    @Operation(
            summary = "Post a new comment",
            description = "Return the comment created",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Comment created"),
                    @ApiResponse(responseCode = "400", description = "User and task must be provided", content = @Content)
            }
    )
    public ResponseEntity<CommentDto> save(@RequestBody @Valid CommentDto commentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.commentService.save(commentDto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update a comment that already exist",
            description = "Return the comment updated",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Comment updated"),
                    @ApiResponse(responseCode = "400", description = "User and task must be provided", content = @Content)
            }
    )
    public ResponseEntity<CommentDto> update(@Parameter(description = "Comment's identifier", example = "5") @PathVariable long id, @RequestBody @Valid UpdateCommentDto updateCommentDto){
        return ResponseEntity.ok(this.commentService.update(id, updateCommentDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a comment that already exist",
            description = "Return the comment deleted",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Comment deleted"),
                    @ApiResponse(responseCode = "400", description = "Comment not exist", content = @Content)
            }
    )
    public ResponseEntity<CommentDto> delete(@Parameter(description = "Comment's identifier", example = "5") @PathVariable long id){
        return ResponseEntity.ok(this.commentService.delete(id));
    }
}
