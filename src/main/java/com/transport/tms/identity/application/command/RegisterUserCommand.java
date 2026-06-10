package com.transport.tms.identity.application.command;

import com.transport.tms.identity.domain.model.Role;

public record RegisterUserCommand(String firstName,
                                  String lastName,
                                  String email,
                                  String mobileNumber,
                                  String password,
                                  Role role) {}
