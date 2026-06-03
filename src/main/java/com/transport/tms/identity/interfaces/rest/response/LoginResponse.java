package com.transport.tms.identity.interfaces.rest.response;

import org.apache.kafka.common.protocol.types.Field;

public record LoginResponse(String accessToken,
                            String tokenType,
                            Long expiresIn) {
//    {
//        "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
//            "tokenType": "Bearer",
//            "expiresIn": 3600
//    }
}
