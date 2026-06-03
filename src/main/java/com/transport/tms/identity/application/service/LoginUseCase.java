package com.transport.tms.identity.application.service;

import com.transport.tms.identity.infrastructure.persistence.UserJpaRepository;
import com.transport.tms.identity.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {
    private final UserJpaRepository userJpaRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
}
