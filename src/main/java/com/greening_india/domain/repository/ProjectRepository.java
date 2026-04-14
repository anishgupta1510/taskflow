package com.greening_india.domain.repository;

import com.greening_india.domain.model.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository {

    Project save(Project project);

    Optional<Project> findById(UUID id);

    List<Project> findByOwnerId(UUID ownerId);

    List<Project> findByUserParticipation(UUID userId);

    void deleteById(UUID id);
}
