package com.greening_india.domain.model;

public enum TaskPriority {
    LOW,
    MEDIUM,
    HIGH;

    public static TaskPriority from(String value) {
        return TaskPriority.valueOf(value.toUpperCase());
    }
}
