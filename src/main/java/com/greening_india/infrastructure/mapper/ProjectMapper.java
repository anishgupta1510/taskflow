package com.greening_india.infrastructure.mapper;

import com.greening_india.domain.model.Project;
import com.greening_india.infrastructure.entity.ProjectEntity;

public class ProjectMapper {

    public static Project toDomain(ProjectEntity e) {
        return new Project(
                e.getId(),
                e.getName(),
                e.getDescription(),
                e.getOwnerId(),
                e.getCreatedAt()
        );
    }

    public static ProjectEntity toEntity(Project d) {
        ProjectEntity e = new ProjectEntity();
        e.setId(d.getId());
        e.setName(d.getName());
        e.setDescription(d.getDescription());
        e.setOwnerId(d.getOwnerId());
        e.setCreatedAt(d.getCreatedAt());
        return e;
    }
}