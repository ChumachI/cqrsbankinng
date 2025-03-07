package com.example.cqrsbanking.service.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.exception.ResourceAlreadyExistsException;
import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.client.ClientService;
import com.example.cqrsbanking.web.dto.LoginRequestDto;
import com.example.cqrsbanking.web.dto.LoginResponseDto;
import com.example.cqrsbanking.web.security.jwt.JwtProperties;
import com.example.cqrsbanking.web.security.jwt.TokenType;

import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final ClientService clientService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder; 

    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        LoginResponseDto response = new LoginResponseDto();
        response.setAccess(tokenService.create(TokenParameters.builder(
            request.getUsername(), TokenType.ACCESS.name(), jwtProperties.getAccess()
        ).build()));
        response.setRefresh(tokenService.create(TokenParameters.builder(
            request.getUsername(), TokenType.ACCESS.name(), jwtProperties.getAccess()
        ).build()));
        return response;
    }
    
    @Override
    public void register(Client client) {
        if(clientService.existsByUsername(client)) {
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }
}
