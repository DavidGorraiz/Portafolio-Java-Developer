package com.dmgorraiz.task_manager_api.domain.exception;

public class IdNotExistException extends RuntimeException {
    public IdNotExistException(long id) {
        super("Id " + id + " not exist");
    }
}
