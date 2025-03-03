package com.example.cqrsbanking.service.client;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.CommandService;
import com.example.cqrsbanking.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {
    
}
