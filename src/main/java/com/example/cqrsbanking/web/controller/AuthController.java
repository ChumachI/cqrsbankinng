package com.example.cqrsbanking.web.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.auth.AuthService;
import com.example.cqrsbanking.web.dto.ClientDto;
import com.example.cqrsbanking.web.dto.LoginRequestDto;
import com.example.cqrsbanking.web.dto.LoginResponseDto;
import com.example.cqrsbanking.web.dto.OnCreate;
import com.example.cqrsbanking.web.dto.mapper.ClientMapper;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) final ClientDto dto) {
        Client client = clientMapper.fromDto(dto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto postMethodName(@RequestBody @Validated LoginRequestDto dto) {
        
        return authService.login(dto);
    }
    
    
}
