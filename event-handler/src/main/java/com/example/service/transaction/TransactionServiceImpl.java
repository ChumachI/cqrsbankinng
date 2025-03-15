package com.example.service.transaction;

import org.springframework.stereotype.Service;

import com.example.common.domain.model.Transaction;
import com.example.common.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private final TransactionRepository repository;

    @Override
    public Transaction create(Transaction transaction) {
        //TODO add logic to change account balances
        return repository.save(transaction);
    }
   
}
