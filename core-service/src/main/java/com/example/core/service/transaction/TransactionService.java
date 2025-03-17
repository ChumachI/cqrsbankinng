package com.example.core.service.transaction;

import com.example.common.domain.model.Transaction;
import com.example.common.service.QueryService;
import com.example.core.service.CommandService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
    
}
