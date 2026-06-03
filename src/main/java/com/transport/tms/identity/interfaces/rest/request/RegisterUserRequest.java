package com.transport.tms.identity.interfaces.rest.request;

import com.transport.tms.identity.domain.model.Role;

public record RegisterUserRequest(String firstName,
                                  String lastName,
                                  String email,
                                  String mobileNumber,
                                  String password,
                                  Role role) {
}
