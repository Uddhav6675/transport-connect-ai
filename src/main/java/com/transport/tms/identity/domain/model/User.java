package com.transport.tms.identity.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String password;
    Role role;
    UserStatus userStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
