package com.greening_india.application.mapper;

import com.greening_india.application.dto.task.TaskResponse;
import com.greening_india.domain.model.Task;

public class TaskDtoMapper {
    public static TaskResponse toResponse(Task t) {
        return new TaskResponse(
                t.getId(),
                t.getTitle(),
                t.getDescription(),
                t.getStatus().name(),
                t.getPriority().name(),
                t.getProjectId(),
                t.getAssigneeId(),
                t.getDueDate(),
                t.getCreatedAt(),
                t.getUpdatedAt()
        );
    }
}
