package com.dmgorraiz.task_manager_api.web.controller;

import com.dmgorraiz.task_manager_api.domain.dto.AttachmentDto;
import com.dmgorraiz.task_manager_api.domain.service.AttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {
    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping
    public ResponseEntity<List<AttachmentDto>> getAll() {
        return ResponseEntity.ok(this.attachmentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDto> getById(@PathVariable long id) {
        AttachmentDto attachmentDto = this.attachmentService.getById(id);

        if (attachmentDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(attachmentDto);
    }

    @PostMapping
    public ResponseEntity<AttachmentDto> save(@RequestBody AttachmentDto attachmentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.attachmentService.save(attachmentDto));
    }
}
