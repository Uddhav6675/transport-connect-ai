package com.transport.tms.identity.application.service;

import com.transport.tms.identity.domain.model.User;
import com.transport.tms.identity.infrastructure.persistence.UserJpaRepository;
import com.transport.tms.identity.infrastructure.security.JwtService;
import com.transport.tms.identity.interfaces.rest.request.LoginRequest;
import com.transport.tms.identity.interfaces.rest.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUserUseCase {
    private final UserJpaRepository userJpaRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request){
        User user = userJpaRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())){
            throw new RuntimeException("Invalid credential");
        }

        return new LoginResponse(
                user.getId(),
                user.getEmail(),
                user.getRole().name(),
                "JWT_COMING_NEXT"
        );
    }
}
