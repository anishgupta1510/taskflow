package com.greening_india.application.dto.task;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record CreateTaskRequest(
        @NotBlank String title,
        String description,
        String priority,
        UUID assigneeId,
        LocalDate dueDate
) {
}
