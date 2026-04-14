package com.greening_india.application.service;

import com.greening_india.application.dto.auth.AuthResponse;
import com.greening_india.application.dto.auth.LoginRequest;
import com.greening_india.application.dto.auth.RegisterRequest;
import com.greening_india.config.JwtService;
import com.greening_india.domain.model.User;
import com.greening_india.domain.repository.UserRepository;
import com.greening_india.interfaces.advice.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new BadRequestException("email already exists");
        }

        User user = new User(
                UUID.randomUUID(),
                request.name(),
                request.email(),
                passwordEncoder.encode(request.password()),
                Instant.now()
        );

        userRepository.save(user);

        String token = jwtService.generateToken(user.getId(), user.getEmail());

        return new AuthResponse(token);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadRequestException("invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadRequestException("invalid credentials");
        }

        String token = jwtService.generateToken(user.getId(), user.getEmail());

        return new AuthResponse(token);
    }
}
