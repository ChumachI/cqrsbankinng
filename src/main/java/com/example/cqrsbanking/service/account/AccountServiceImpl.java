package com.example.cqrsbanking.service.account;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Account;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountQueryService queryService;
    private AccountCommandService commandService;
    @Override
    public Account getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void create(Account object) {
        commandService.create(object);
    }
    
}
