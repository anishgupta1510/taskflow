package com.greening_india.infrastructure.persistence;

import com.greening_india.domain.model.Project;
import com.greening_india.domain.repository.ProjectRepository;
import com.greening_india.infrastructure.mapper.ProjectMapper;
import com.greening_india.infrastructure.repository.JpaProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepository {

    private final JpaProjectRepository jpa;

    @Override
    public Project save(Project project) {
        return ProjectMapper.toDomain(
                jpa.save(ProjectMapper.toEntity(project))
        );
    }

    @Override
    public Optional<Project> findById(UUID id) {
        return jpa.findById(id)
                .map(ProjectMapper::toDomain);
    }

    @Override
    public List<Project> findByOwnerId(UUID ownerId) {
        return jpa.findByOwnerId(ownerId)
                .stream()
                .map(ProjectMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> findByUserParticipation(UUID userId) {
        // will be implemented via custom query later
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }
}
