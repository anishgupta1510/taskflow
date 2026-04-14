package com.greening_india.domain.model;

import java.time.Instant;
import java.util.UUID;

public class User {

    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
    private final Instant createdAt;

    public User(UUID id, String name, String email, String password, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
