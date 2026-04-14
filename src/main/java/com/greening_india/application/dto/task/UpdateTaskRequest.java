package com.greening_india.application.dto.task;

import java.time.LocalDate;
import java.util.UUID;

public record UpdateTaskRequest(
        String title,
        String description,
        String status,
        String priority,
        UUID assigneeId,
        LocalDate dueDate
) {
}
