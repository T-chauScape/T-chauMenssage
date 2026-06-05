package com.tchau.message.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "Users")
public class JpaUser extends JpaBaseEntity {
    @Column(length = 100,nullable = false, updatable = true)
    private String nickname;

    @Column(length = 64, nullable = false,updatable = true)
    private String password;

    @Column(length = 256, unique = true,nullable = false,updatable = true)
    private String email;

    @Column(nullable = false,updatable = true)
    private String role;
}