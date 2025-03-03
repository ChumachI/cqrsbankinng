package com.example.cqrsbanking.service.transaction;

import com.example.cqrsbanking.domain.model.Transaction;
import com.example.cqrsbanking.service.CommandService;

public interface TransactionCommandService  extends CommandService<Transaction>{
    
}
