package com.example.cqrsbanking.service.transaction;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.exception.ResourceNotFoundException;
import com.example.cqrsbanking.domain.model.Transaction;
import com.example.cqrsbanking.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionQueryServiceImpl implements TransactionQueryService {

    private final TransactionRepository repository;

    @Override
    public Transaction getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    
}
