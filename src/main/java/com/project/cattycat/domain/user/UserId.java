package com.project.cattycat.domain.user;

import lombok.EqualsAndHashCode;

import java.util.UUID;
@EqualsAndHashCode
public class UserId {

    private final UUID id;

    public UserId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
