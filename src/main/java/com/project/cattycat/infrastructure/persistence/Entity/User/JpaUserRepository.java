package com.project.cattycat.infrastructure.persistence.Entity.User;

import com.project.cattycat.domain.user.User;
import com.project.cattycat.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository springRepo;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByEmail(String email) {
        return springRepo.findByEmail(email)
                .map(userMapper::toDomain);
    }
    @Override
    public void save(User user) {
        springRepo.save(userMapper.toEntity(user));
    }
}
