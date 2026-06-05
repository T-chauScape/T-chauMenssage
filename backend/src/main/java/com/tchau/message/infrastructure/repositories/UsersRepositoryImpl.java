package com.tchau.message.infrastructure.repositories;

import com.tchau.message.domain.User.User;
import com.tchau.message.infrastructure.entities.JpaUser;
import com.tchau.message.utils.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class UsersRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByEmail(String email) {
        var jpaUser = jpaUserRepository.findByEmail(email);
        return jpaUser.map(userMapper::toDomain);
    }

    @Override
    public void save(User user) {
        JpaUser jpaUser = userMapper.toEntity(user);
        jpaUserRepository.save(jpaUser);
    }
}