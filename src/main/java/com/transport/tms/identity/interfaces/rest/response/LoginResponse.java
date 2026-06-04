package com.transport.tms.identity.interfaces.rest.response;

import java.util.UUID;

public record LoginResponse(UUID userId,
                            String email,
                            String role,
                            String accessToken){}
