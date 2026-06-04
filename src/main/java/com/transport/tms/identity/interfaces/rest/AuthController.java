package com.transport.tms.identity.interfaces.rest;

import com.transport.tms.identity.application.command.RegisterUserCommand;
import com.transport.tms.identity.application.service.RegisterUserUseCase;
import com.transport.tms.identity.interfaces.rest.request.RegisterUserRequest;
import com.transport.tms.identity.interfaces.rest.response.RegisterUserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
        RegisterUserCommand command = new RegisterUserCommand(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.mobileNumber(),
                request.password(),
                request.role()
        );

        RegisterUserResponse response = registerUserUseCase.register(command);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(response);
    }
}
