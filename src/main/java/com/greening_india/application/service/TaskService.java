package com.greening_india.application.service;

import com.greening_india.application.dto.task.CreateTaskRequest;
import com.greening_india.application.dto.task.TaskResponse;
import com.greening_india.application.dto.task.UpdateTaskRequest;
import com.greening_india.application.mapper.TaskDtoMapper;
import com.greening_india.domain.model.Task;
import com.greening_india.domain.model.TaskPriority;
import com.greening_india.domain.model.TaskStatus;
import com.greening_india.domain.repository.TaskRepository;
import com.greening_india.interfaces.advice.exceptions.ForbiddenException;
import com.greening_india.interfaces.advice.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskResponse create(UUID projectId, CreateTaskRequest request) {

        Task task = new Task(
                UUID.randomUUID(),
                request.title(),
                request.description(),
                TaskStatus.TODO,
                TaskPriority.from(request.priority()),
                projectId,
                request.assigneeId(),
                request.dueDate(),
                Instant.now(),
                Instant.now()
        );

        return TaskDtoMapper.toResponse(
                taskRepository.save(task)
        );
    }

    public List<TaskResponse> list(UUID projectId, String status, UUID assigneeId) {

        return taskRepository.findByProjectIdAndFilters(
                        projectId,
                        status != null ? TaskStatus.from(status) : null,
                        assigneeId
                )
                .stream()
                .map(TaskDtoMapper::toResponse)
                .toList();
    }

    public TaskResponse update(UUID taskId, UpdateTaskRequest request) {

        Task existing = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("task not found"));

        Task updated = new Task(
                existing.getId(),
                request.title() != null ? request.title() : existing.getTitle(),
                request.description() != null ? request.description() : existing.getDescription(),
                request.status() != null ? TaskStatus.from(request.status()) : existing.getStatus(),
                request.priority() != null ? TaskPriority.from(request.priority()) : existing.getPriority(),
                existing.getProjectId(),
                request.assigneeId() != null ? request.assigneeId() : existing.getAssigneeId(),
                request.dueDate() != null ? request.dueDate() : existing.getDueDate(),
                existing.getCreatedAt(),
                Instant.now()
        );

        return TaskDtoMapper.toResponse(
                taskRepository.save(updated)
        );
    }

    public void delete(UUID taskId, UUID currentUserId) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("task not found"));

        if (!task.getAssigneeId().equals(currentUserId)) {
            throw new ForbiddenException("not allowed");
        }

        taskRepository.deleteById(taskId);
    }
}