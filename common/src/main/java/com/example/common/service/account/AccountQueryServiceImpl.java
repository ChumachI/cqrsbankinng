package com.example.common.service.account;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.common.domain.exception.ResourceNotFoundException;
import com.example.common.domain.model.Account;
import com.example.common.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountQueryServiceImpl implements AccountQueryService {

    private final AccountRepository repository;

    @Override
    public Account getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    
}
