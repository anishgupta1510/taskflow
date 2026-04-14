package com.greening_india.application.service;

import com.greening_india.application.dto.project.CreateProjectRequest;
import com.greening_india.application.dto.project.ProjectResponse;
import com.greening_india.application.mapper.ProjectDtoMapper;
import com.greening_india.domain.model.Project;
import com.greening_india.domain.repository.ProjectRepository;
import com.greening_india.interfaces.advice.exceptions.ForbiddenException;
import com.greening_india.interfaces.advice.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectResponse create(UUID userId, CreateProjectRequest request) {

        Project project = new Project(
                UUID.randomUUID(),
                request.name(),
                request.description(),
                userId,
                Instant.now()
        );

        return ProjectDtoMapper.toResponse(
                projectRepository.save(project)
        );
    }

    public List<ProjectResponse> getUserProjects(UUID userId) {
        return projectRepository.findByOwnerId(userId)
                .stream()
                .map(ProjectDtoMapper::toResponse)
                .toList();
    }

    public ProjectResponse getById(UUID id) {
        return projectRepository.findById(id)
                .map(ProjectDtoMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("project not found"));
    }

    public void delete(UUID id, UUID userId) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("project not found"));

        if (!project.getOwnerId().equals(userId)) {
            throw new ForbiddenException("not allowed");
        }

        projectRepository.deleteById(id);
    }

    public ProjectResponse update(UUID id, UUID userId, CreateProjectRequest request) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("project not found"));

        if (!project.getOwnerId().equals(userId)) {
            throw new ForbiddenException("not allowed");
        }

        Project updated = new Project(
                project.getId(),
                request.name() != null ? request.name() : project.getName(),
                request.description() != null ? request.description() : project.getDescription(),
                project.getOwnerId(),
                project.getCreatedAt()
        );

        return ProjectDtoMapper.toResponse(
                projectRepository.save(updated)
        );
    }
}
