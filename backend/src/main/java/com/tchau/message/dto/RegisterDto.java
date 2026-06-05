package com.tchau.message.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDto(
        @NotBlank
        String NickName,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
