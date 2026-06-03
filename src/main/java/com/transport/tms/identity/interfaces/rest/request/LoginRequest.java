package com.transport.tms.identity.interfaces.rest.request;

public record LoginRequest(String email,
                           String password) {
}
