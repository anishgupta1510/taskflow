package com.greening_india.interfaces.controller;

import com.greening_india.application.dto.project.CreateProjectRequest;
import com.greening_india.application.dto.project.ProjectResponse;
import com.greening_india.application.service.ProjectService;
import com.greening_india.config.CustomerUserPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    private UUID getCurrentUserId() {
        CustomerUserPrincipal user =
                (CustomerUserPrincipal) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

        return user.getUserId();
    }

    // GET /projects
    @GetMapping
    public List<ProjectResponse> getProjects() {
        return projectService.getUserProjects(getCurrentUserId());
    }

    // POST /projects
    @PostMapping
    public ProjectResponse create(@Valid @RequestBody CreateProjectRequest request) {
        return projectService.create(getCurrentUserId(), request);
    }

    // GET /projects/:id
    @GetMapping("/{id}")
    public ProjectResponse getById(@PathVariable UUID id) {
        return projectService.getById(id);
    }

    // PATCH /projects/:id
    @PatchMapping("/{id}")
    public ProjectResponse update(
            @PathVariable UUID id,
            @RequestBody CreateProjectRequest request
    ) {
        return projectService.update(id, getCurrentUserId(), request);
    }

    // DELETE /projects/:id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        projectService.delete(id, getCurrentUserId());
    }
}
