package com.greening_india.domain.repository;

import com.greening_india.domain.model.Task;
import com.greening_india.domain.model.TaskStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {

    Task save(Task task);

    Optional<Task> findById(UUID id);

    List<Task> findByProjectId(UUID projectId);

    List<Task> findByProjectIdAndFilters(
            UUID projectId,
            TaskStatus status,
            UUID assigneeId
    );

    void deleteById(UUID id);

    long countByProjectId(UUID projectId);

    long countByProjectIdAndStatus(UUID projectId, TaskStatus status);
}
