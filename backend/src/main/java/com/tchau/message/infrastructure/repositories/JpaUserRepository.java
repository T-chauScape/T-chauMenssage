package com.tchau.message.infrastructure.repositories;

import com.tchau.message.infrastructure.entities.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<JpaUser,UUID> {

    Optional<JpaUser> findByEmail(String email);
}
