package com.tchau.message.dto.login;

import jakarta.validation.constraints.Email;

public record LoginRequestDTO(
        @Email
        String email,
        String password
) {
}
