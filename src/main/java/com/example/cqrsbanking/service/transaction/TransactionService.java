package com.example.cqrsbanking.service.transaction;

import com.example.cqrsbanking.domain.model.Transaction;
import com.example.cqrsbanking.service.CommandService;
import com.example.cqrsbanking.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
    
}
