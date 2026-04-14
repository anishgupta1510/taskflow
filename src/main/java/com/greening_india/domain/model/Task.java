package com.greening_india.domain.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private final UUID id;
    private final String title;
    private final String description;
    private final TaskStatus status;
    private final TaskPriority priority;
    private final UUID projectId;
    private final UUID assigneeId;
    private final LocalDate dueDate;
    private final Instant createdAt;
    private final Instant updatedAt;

    public Task(
            UUID id,
            String title,
            String description,
            TaskStatus status,
            TaskPriority priority,
            UUID projectId,
            UUID assigneeId,
            LocalDate dueDate,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.projectId = projectId;
        this.assigneeId = assigneeId;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public UUID getAssigneeId() {
        return assigneeId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
