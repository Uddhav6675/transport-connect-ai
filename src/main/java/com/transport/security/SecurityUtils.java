package com.transport.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class SecurityUtils {

    public static UUID getCurrentUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        assert authentication != null;
        CustomerUserDetails user = (CustomerUserDetails) authentication.getPrincipal();

        assert user != null;
        return user.getUserId();
    }
}
