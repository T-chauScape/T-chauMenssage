package com.tchau.message.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseDomain {
    @EqualsAndHashCode.Include
    @Builder.Default
    private UUID id = UUID.randomUUID();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
