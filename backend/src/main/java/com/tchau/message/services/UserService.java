package com.tchau.message.services;

import com.tchau.message.domain.User.User;
import com.tchau.message.dto.login.LoginRequestDTO;
import com.tchau.message.dto.RegisterDto;
import com.tchau.message.exception.EmailAlreadyExistException;
import com.tchau.message.infrastructure.repositories.UsersRepositoryImpl;
import com.tchau.message.infrastructure.security.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UsersRepositoryImpl usersRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public String login(LoginRequestDTO loginRequestDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginRequestDTO.email(), loginRequestDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return tokenService.generateToken((User) auth.getPrincipal());
    }

    public void register(RegisterDto registerDto){
        if (usersRepository.findByEmail(registerDto.email()).isPresent()){
            throw new EmailAlreadyExistException();
        }

        var cryptedPassword = passwordEncoder.encode(registerDto.password());

        User newUser = User.builder()
                .nickname(registerDto.NickName())
                .email(registerDto.email())
                .password(cryptedPassword)
                .build();

        usersRepository.save(newUser);
    }
}
