package com.transport.tms.identity.interfaces.rest.request;

import com.transport.tms.identity.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterUserRequest(@NotBlank
                                  String firstName,
                                  @NotBlank
                                  String lastName,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank
                                  String mobileNumber,
                                  @NotBlank
                                  String password,
                                  @NotNull
                                  Role role) {
}
