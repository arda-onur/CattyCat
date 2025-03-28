package com.project.cattycat.domain.user;

import com.project.cattycat.infrastructure.persistence.Entity.User.UserEntity;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
}
