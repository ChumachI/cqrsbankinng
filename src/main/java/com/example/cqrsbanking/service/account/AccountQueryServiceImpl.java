package com.example.cqrsbanking.service.account;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.exception.ResourceNotFoundException;
import com.example.cqrsbanking.domain.model.Account;
import com.example.cqrsbanking.repository.AccountRepository;

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
