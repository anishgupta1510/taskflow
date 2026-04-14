package com.greening_india.infrastructure.persistence;

import com.greening_india.domain.model.User;
import com.greening_india.domain.repository.UserRepository;
import com.greening_india.infrastructure.mapper.UserMapper;
import com.greening_india.infrastructure.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpa;

    @Override
    public User save(User user) {
        return UserMapper.toDomain(
                jpa.save(UserMapper.toEntity(user))
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpa.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpa.findById(id)
                .map(UserMapper::toDomain);
    }
}
