package com.transport.security;

import com.transport.tms.identity.domain.model.User;
import com.transport.tms.identity.infrastructure.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserJpaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         User user = repository.findByEmail(email)
                 .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new CustomerUserDetails(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                java.util.List.of(new SimpleGrantedAuthority(
                        "ROLE_" + user.getRole().name()
                ))
        );
    }
}
