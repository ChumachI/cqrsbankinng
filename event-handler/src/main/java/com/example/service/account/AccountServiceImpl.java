package com.example.service.account;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.common.domain.model.Account;
import com.example.common.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public Account create(Account account) {
        account.setBalance(BigDecimal.ZERO);
        account.setNumber(UUID.randomUUID().toString());

        return repository.save(account);
    }
    
}
