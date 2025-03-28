package com.project.cattycat.infrastructure.persistence.Entity.User;

import com.project.cattycat.domain.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    private UUID id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @Embedded
    private AddressEmbeddable embeddable;
}
