package com.kartik.backend.tasks.exceptions;

public class  DueDateException extends IllegalArgumentException {       // static class is used to access that class outside the TaskService class.
    public DueDateException(String message) {
        super(message);
    }
}