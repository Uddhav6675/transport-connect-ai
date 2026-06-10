package com.transport.tms.identity.interfaces.rest.response;

import java.util.UUID;

public record RegisterUserResponse(UUID userId,
                                   String firstName,
                                   String lastName,
                                   String email,
                                   String role,
                                   String message) {}
