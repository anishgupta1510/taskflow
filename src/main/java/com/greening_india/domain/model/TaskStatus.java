package com.greening_india.domain.model;

public enum TaskStatus {
    TODO,
    IN_PROGRESS,
    DONE;

    public static TaskStatus from(String value) {
        return TaskStatus.valueOf(value.toUpperCase());
    }
}
