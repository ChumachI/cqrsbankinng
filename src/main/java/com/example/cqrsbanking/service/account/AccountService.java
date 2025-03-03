package com.example.cqrsbanking.service.account;

import com.example.cqrsbanking.domain.model.Account;
import com.example.cqrsbanking.service.CommandService;
import com.example.cqrsbanking.service.QueryService;

public interface AccountService extends QueryService<Account>, CommandService<Account> {
    
}
