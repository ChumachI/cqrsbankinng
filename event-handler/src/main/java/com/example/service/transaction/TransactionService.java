package com.example.service.transaction;

import com.example.common.domain.model.Transaction;

public interface TransactionService {
    Transaction create(Transaction transaction);
}
