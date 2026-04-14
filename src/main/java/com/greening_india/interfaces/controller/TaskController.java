package com.greening_india.interfaces.controller;

import com.greening_india.application.dto.task.CreateTaskRequest;
import com.greening_india.application.dto.task.TaskResponse;
import com.greening_india.application.dto.task.UpdateTaskRequest;
import com.greening_india.application.service.TaskService;
import com.greening_india.config.CustomerUserPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    private UUID getCurrentUserId() {
        CustomerUserPrincipal user =
                (CustomerUserPrincipal) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

        return user.getUserId();
    }

    // GET /projects/:id/tasks?status=&assignee=
    @GetMapping("/projects/{projectId}/tasks")
    public List<TaskResponse> list(
            @PathVariable UUID projectId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) UUID assignee
    ) {
        return taskService.list(projectId, status, assignee);
    }

    // POST /projects/:id/tasks
    @PostMapping("/projects/{projectId}/tasks")
    public TaskResponse create(
            @PathVariable UUID projectId,
            @Valid @RequestBody CreateTaskRequest request
    ) {
        return taskService.create(projectId, request);
    }

    // PATCH /tasks/:id
    @PatchMapping("/tasks/{id}")
    public TaskResponse update(
            @PathVariable UUID id,
            @RequestBody UpdateTaskRequest request
    ) {
        return taskService.update(id, request);
    }

    // DELETE /tasks/:id
    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable UUID id) {
        taskService.delete(id, getCurrentUserId());
    }
}
