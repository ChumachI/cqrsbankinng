package com.example.cqrsbanking.service.auth;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.web.dto.LoginRequestDto;
import com.example.cqrsbanking.web.dto.LoginResponseDto;

public interface AuthService {
    void register(Client client);
    LoginResponseDto login(LoginRequestDto request);
}
