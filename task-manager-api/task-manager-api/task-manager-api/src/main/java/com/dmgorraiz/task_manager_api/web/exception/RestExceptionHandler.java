package com.dmgorraiz.task_manager_api.web.exception;

import com.dmgorraiz.task_manager_api.domain.exception.IdAlreadyExistsException;
import com.dmgorraiz.task_manager_api.domain.exception.IdNotExistException;
import com.dmgorraiz.task_manager_api.domain.exception.UserNotExistException;
import com.dmgorraiz.task_manager_api.domain.exception.UsernameAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(UsernameAlreadyExistsException ex) {
        Error error = new Error("username-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<Error> handleException(UserNotExistException ex) {
        Error error = new Error("user-not-exist", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(IdAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(IdAlreadyExistsException ex) {
        Error error = new Error("id-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(IdNotExistException.class)
    public ResponseEntity<Error> handleException(IdNotExistException ex) {
        Error error = new Error("id-not-exist", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error("unknown-error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
