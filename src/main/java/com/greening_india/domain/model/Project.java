package com.greening_india.domain.model;

import java.time.Instant;
import java.util.UUID;

public class Project {

    private final UUID id;
    private final String name;
    private final String description;
    private final UUID ownerId;
    private final Instant createdAt;

    public Project(UUID id, String name, String description, UUID ownerId, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}