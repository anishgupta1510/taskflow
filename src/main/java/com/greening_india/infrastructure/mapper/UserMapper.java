package com.greening_india.infrastructure.mapper;

import com.greening_india.domain.model.User;
import com.greening_india.infrastructure.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity e) {
        return new User(
                e.getId(),
                e.getName(),
                e.getEmail(),
                e.getPassword(),
                e.getCreatedAt()
        );
    }

    public static UserEntity toEntity(User d) {
        UserEntity e = new UserEntity();
        e.setId(d.getId());
        e.setName(d.getName());
        e.setEmail(d.getEmail());
        e.setPassword(d.getPassword());
        e.setCreatedAt(d.getCreatedAt());
        return e;
    }
}