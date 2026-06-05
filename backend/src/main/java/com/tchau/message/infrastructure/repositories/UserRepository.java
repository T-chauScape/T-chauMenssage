package com.tchau.message.infrastructure.repositories;

import com.tchau.message.domain.User.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
}
