package com.example.cqrsbanking.web.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.client.ClientService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService{
    
    private final ClientService clientService;
    
    @Override 
    @SneakyThrows
    public UserDetails loadUserByUsername(String username) {
        Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }
    
}
