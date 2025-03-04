package com.example.cqrsbanking.service.auth;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.exception.ResourceAlreadyExistsException;
import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.client.ClientService;
import com.example.cqrsbanking.web.dto.LoginRequestDto;
import com.example.cqrsbanking.web.dto.LoginResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ClientService clientService;

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        //TODO implement
        return null;
    }
    
    @Override
    public void register(Client client) {
        if(clientService.existsByUsername(client)) {
            throw new ResourceAlreadyExistsException();
        }

        //TODO hash password
        client.setPassword(client.getPassword());
        clientService.create(client);
    }
}
