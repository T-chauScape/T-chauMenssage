package com.tchau.message.models.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID uuid;

    @Column(nullable = false, updatable = false)
    private LocalDateTime CreatedAt;

    @Column(nullable = false, updatable = true)
    private LocalDateTime UpdatedAt;
}
