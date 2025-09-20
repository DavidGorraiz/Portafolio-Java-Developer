package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.dto.UpdateAttachmentDto;
import com.dmgorraiz.task_manager_api.domain.service.AttachmentService;
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
@RequestMapping("/attachments")
@Tag(name = "Attachments", description = "Operations about attachments")
public class AttachmentController {
    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping
    @Operation(
            summary = "Get all the attachments",
            description = "Return a list of all the attachments",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All attachments")
            }
    )
    public ResponseEntity<List<AttachmentDto>> getAll() {
        return ResponseEntity.ok(this.attachmentService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get an attachment by its id",
            description = "Return an attachment by its id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Attachment found"),
                    @ApiResponse(responseCode = "404", description = "Attachment not found", content = @Content)
            }
    )
    public ResponseEntity<AttachmentDto> getById(@Parameter(description = "Attachment's identifier", example = "5") @PathVariable long id) {
        AttachmentDto attachmentDto = this.attachmentService.getById(id);

        if (attachmentDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(attachmentDto);
    }

    @PostMapping
    @Operation(
            summary = "Post a new attachment",
            description = "Create an attachment in the database",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Attachment created"),
                    @ApiResponse(responseCode = "400", description = "Attachemtn must have file ur, user id and task id", content = @Content)
            }
    )
    public ResponseEntity<AttachmentDto> save(@RequestBody @Valid AttachmentDto attachmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.attachmentService.save(attachmentDto));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update an attachment that aleady exist",
            description = "Update an attachment",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Attachment updated"),
                    @ApiResponse(responseCode = "400", description = "Miss url, user or task", content = @Content)
            }
    )
    public ResponseEntity<AttachmentDto> update(@Parameter(description = "Attachment's identifier", example = "5") @PathVariable long id, @RequestBody @Valid UpdateAttachmentDto updateAttachmentDto) {
        return ResponseEntity.ok(this.attachmentService.update(id, updateAttachmentDto));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete an attachment that already exist",
            description = "Delete an attachment",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Attachment deleted"),
                    @ApiResponse(responseCode = "400", description = "Attachment not exist", content = @Content)
            }
    )
    public ResponseEntity<AttachmentDto> delete(@Parameter(description = "Attachment's identifier", example = "5") @PathVariable long id) {
        return ResponseEntity.ok(this.attachmentService.delete(id));
    }
}
