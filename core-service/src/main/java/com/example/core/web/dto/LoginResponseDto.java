package com.example.core.web.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private UUID id;
    private String access;
    private String refresh;
}
