package com.example.core.service.account;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.common.domain.model.Account;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService queryService;
    private final AccountCommandService commandService;
    @Override
    public Account getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void create(Account object) {
        commandService.create(object);
    }
    
}
