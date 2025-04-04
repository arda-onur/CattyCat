package com.project.cattycat.infrastructure.persistence.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryImpl extends JpaRepository<UserEntity,UUID> {
    Optional<UserEntity> findByEmail(String email);
}
