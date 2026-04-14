package com.greening_india.application.dto.task;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record TaskResponse(
        UUID id,
        String title,
        String description,
        String status,
        String priority,
        UUID projectId,
        UUID assigneeId,
        LocalDate dueDate,
        Instant createdAt,
        Instant updatedAt
) {
}
