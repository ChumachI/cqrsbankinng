package com.example.cqrsbanking.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.cqrsbanking.domain.model.Client;

import lombok.Data;

@Data
public class SecurityUser implements UserDetails {

    private final UUID id;
    private final String username;
    private final String password;
    private final Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(final Client user){
        this(user.getId(),user.getUsername(), user.getPassword());
        this.authorities.add(mapToGrantedAuthorities("ROLE_USER"));
    }

    public SecurityUser(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = new ArrayList<>();
    }

    private SimpleGrantedAuthority mapToGrantedAuthorities(final String role) {
        return new SimpleGrantedAuthority(role);
    }
}
