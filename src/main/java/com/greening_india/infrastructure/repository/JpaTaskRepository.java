package com.greening_india.infrastructure.repository;

import com.greening_india.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, UUID> {
    List<TaskEntity> findByProjectId(UUID projectId);

    List<TaskEntity> findByProjectIdAndStatus(UUID projectId, String status);

    List<TaskEntity> findByProjectIdAndAssigneeId(UUID projectId, UUID assigneeId);

    List<TaskEntity> findByProjectIdAndStatusAndAssigneeId(
            UUID projectId,
            String status,
            UUID assigneeId
    );

    long countByProjectId(UUID projectId);

    long countByProjectIdAndStatus(UUID projectId, String status);
}
