package com.transport.tms.identity.interfaces.rest.response;

import org.apache.kafka.common.protocol.types.Field;

import java.util.UUID;

public record RegisterUserResponse(UUID userId,
                                   String firstName,
                                   String lastName,
                                   String email,
                                   String role,
                                   String message) {
//    {
//        "userId": "8f5f4e89-7f2a-4c96-bc89-6f0f0a1d1c11",
//            "firstName": "Uddhav",
//            "lastName": "Karad",
//            "email": "uddhav@test.com",
//            "role": "TRANSPORTER",
//            "message": "User registered successfully"
//    }
}
