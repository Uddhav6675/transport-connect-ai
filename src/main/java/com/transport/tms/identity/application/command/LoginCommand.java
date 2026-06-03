package com.transport.tms.identity.application.command;

public record LoginCommand(String email,
                           String password) {}
