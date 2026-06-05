package com.tchau.message.utils.mappers;

import com.tchau.message.domain.User.User;
import com.tchau.message.domain.User.UserRole;
import com.tchau.message.infrastructure.entities.JpaUser;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(JpaUser jpaUser) {
        if (jpaUser == null) {
            return null;
        }
        System.out.println("teste aqui");
        return User.builder()
                .id(jpaUser.getId())
                .createdAt(jpaUser.getCreatedAt())
                .updatedAt(jpaUser.getUpdatedAt())
                .nickname(jpaUser.getNickname())
                .email(jpaUser.getEmail())
                .password(jpaUser.getPassword())
                .role(UserRole.valueOf(jpaUser.getRole()))
                .build();
    }
    public JpaUser toEntity(User user) {
        if (user == null) {
            return null;
        }
        JpaUser jpaUser = new JpaUser();
        jpaUser.setId(user.getId());
        jpaUser.setCreatedAt(user.getCreatedAt());
        jpaUser.setUpdatedAt(user.getUpdatedAt());
        jpaUser.setNickname(user.getNickname());
        jpaUser.setEmail(user.getEmail());
        jpaUser.setPassword(user.getPassword());
        jpaUser.setRole(String.valueOf(user.getRole()));

        return jpaUser;
    }
}
