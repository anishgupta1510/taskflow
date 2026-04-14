package com.greening_india.infrastructure.persistence;

import com.greening_india.domain.model.Task;
import com.greening_india.domain.model.TaskStatus;
import com.greening_india.domain.repository.TaskRepository;
import com.greening_india.infrastructure.entity.TaskEntity;
import com.greening_india.infrastructure.mapper.TaskMapper;
import com.greening_india.infrastructure.repository.JpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {
    private final JpaTaskRepository jpa;

    @Override
    public Task save(Task task) {
        return TaskMapper.toDomain(
                jpa.save(TaskMapper.toEntity(task))
        );
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return jpa.findById(id)
                .map(TaskMapper::toDomain);
    }

    @Override
    public List<Task> findByProjectId(UUID projectId) {
        return jpa.findByProjectId(projectId)
                .stream()
                .map(TaskMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> findByProjectIdAndFilters(UUID projectId, TaskStatus status, UUID assigneeId) {

        List<TaskEntity> entities;

        if (status != null && assigneeId != null) {
            entities = jpa.findByProjectIdAndStatusAndAssigneeId(projectId, status.name(), assigneeId);
        } else if (status != null) {
            entities = jpa.findByProjectIdAndStatus(projectId, status.name());
        } else if (assigneeId != null) {
            entities = jpa.findByProjectIdAndAssigneeId(projectId, assigneeId);
        } else {
            entities = jpa.findByProjectId(projectId);
        }

        return entities.stream()
                .map(TaskMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }

    @Override
    public long countByProjectId(UUID projectId) {
        return jpa.countByProjectId(projectId);
    }

    @Override
    public long countByProjectIdAndStatus(UUID projectId, TaskStatus status) {
        return jpa.countByProjectIdAndStatus(projectId, status.name());
    }
}
