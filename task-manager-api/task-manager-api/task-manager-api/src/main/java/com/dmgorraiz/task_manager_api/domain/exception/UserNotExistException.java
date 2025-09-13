package com.dmgorraiz.task_manager_api.domain.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(long id) {
        super("User with id " + id + " does not exist");
    }
}
