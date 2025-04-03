package com.project.cattycat.application.authentication;

import com.project.cattycat.application.dto.RegisterRequestDTO;
import com.project.cattycat.domain.user.Role;
import com.project.cattycat.domain.user.User;
import com.project.cattycat.infrastructure.Exception.EmailAlreadyExists;
import com.project.cattycat.infrastructure.configuration.security.jsonwebtoken.JwtService;
import com.project.cattycat.infrastructure.persistence.Entity.User.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequestDTO registerRequestDTO)  {
        this.userRepository.findByEmail(registerRequestDTO.getEmail())
                .ifPresent(existingUser -> {
                    throw new EmailAlreadyExists("User already exists");
                });

        User newUser = User.builder()
                .email(registerRequestDTO.getEmail().toLowerCase())
                .password(this.passwordEncoder.encode(registerRequestDTO.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(newUser);
        return jwtService.generateToken(new HashMap<>(),newUser);
    }
}
