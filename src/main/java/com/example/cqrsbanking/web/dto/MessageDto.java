package com.example.cqrsbanking.web.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageDto {
    private String message;
    private Map<String, String> errors;
    
    public MessageDto(String message) {
        this.message = message;
        this.errors = new HashMap<>();
    }
}
