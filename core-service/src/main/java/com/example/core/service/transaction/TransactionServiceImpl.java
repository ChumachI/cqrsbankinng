package com.example.core.service.transaction;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.common.domain.model.Transaction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionQueryService queryService;
    private final TransactionCommandService commandService;
    @Override
    public Transaction getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void create(Transaction object) {
        commandService.create(object);
    }
    
}
