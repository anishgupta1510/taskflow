package com.greening_india.infrastructure.repository;

import com.greening_india.infrastructure.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaProjectRepository extends JpaRepository<ProjectEntity, UUID> {
    List<ProjectEntity> findByOwnerId(UUID ownerId);
}
