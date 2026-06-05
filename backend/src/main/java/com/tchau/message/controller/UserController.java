package com.tchau.message.controller;

import com.tchau.message.dto.login.LoginRequestDTO;
import com.tchau.message.dto.RegisterDto;
import com.tchau.message.dto.login.LoginResponseDTO;
import com.tchau.message.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDto registerDto){
        userService.register(registerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
        var token = userService.login(loginRequestDTO);
        return ResponseEntity.ok(new LoginResponseDTO(token));

    }
}
