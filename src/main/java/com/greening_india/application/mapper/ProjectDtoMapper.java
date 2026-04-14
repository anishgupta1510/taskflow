package com.greening_india.application.mapper;

import com.greening_india.application.dto.project.ProjectResponse;
import com.greening_india.domain.model.Project;

public class ProjectDtoMapper {
    public static ProjectResponse toResponse(Project p) {
        return new ProjectResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getOwnerId(),
                p.getCreatedAt()
        );
    }
}
