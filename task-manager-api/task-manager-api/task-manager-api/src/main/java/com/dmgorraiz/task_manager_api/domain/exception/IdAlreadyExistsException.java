package com.dmgorraiz.task_manager_api.domain.exception;

public class IdAlreadyExistsException extends RuntimeException {
    public IdAlreadyExistsException(long id) {
        super("Id " + id + " already exists");
    }
}
