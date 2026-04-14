package com.greening_india.infrastructure.mapper;

import com.greening_india.domain.model.Task;
import com.greening_india.domain.model.TaskPriority;
import com.greening_india.domain.model.TaskStatus;
import com.greening_india.infrastructure.entity.TaskEntity;

public class TaskMapper {

    public static Task toDomain(TaskEntity e) {
        return new Task(
                e.getId(),
                e.getTitle(),
                e.getDescription(),
                TaskStatus.from(e.getStatus()),
                TaskPriority.from(e.getPriority()),
                e.getProjectId(),
                e.getAssigneeId(),
                e.getDueDate(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }

    public static TaskEntity toEntity(Task d) {
        TaskEntity e = new TaskEntity();
        e.setId(d.getId());
        e.setTitle(d.getTitle());
        e.setDescription(d.getDescription());
        e.setStatus(d.getStatus().name());
        e.setPriority(d.getPriority().name());
        e.setProjectId(d.getProjectId());
        e.setAssigneeId(d.getAssigneeId());
        e.setDueDate(d.getDueDate());
        e.setCreatedAt(d.getCreatedAt());
        e.setUpdatedAt(d.getUpdatedAt());
        return e;
    }
}