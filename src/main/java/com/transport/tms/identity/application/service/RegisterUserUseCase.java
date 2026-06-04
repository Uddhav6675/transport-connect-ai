package com.transport.tms.identity.application.service;

import com.transport.tms.identity.application.command.RegisterUserCommand;
import com.transport.tms.identity.domain.model.User;
import com.transport.tms.identity.domain.model.UserStatus;
import com.transport.tms.identity.infrastructure.persistence.UserJpaRepository;
import com.transport.tms.identity.interfaces.rest.response.RegisterUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase {
    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;


    public RegisterUserResponse register(RegisterUserCommand command){
        if(userJpaRepository.existsByEmail(command.email())){
            throw new RuntimeException("User already exists");
        }
        User user = new User();

        user.setFirstName(command.firstName());
        user.setLastName(command.lastName());
        user.setEmail(command.email());
        user.setMobileNumber(command.mobileNumber());
        user.setPassword(passwordEncoder.encode(command.password()));
        user.setRole(command.role());
        user.setStatus(UserStatus.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser = userJpaRepository.save(user);

        return new RegisterUserResponse(savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                savedUser.getRole().name(),
                "User registered successfully");
    }

}
