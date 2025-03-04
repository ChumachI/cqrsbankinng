package com.example.cqrsbanking.service.client;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    boolean existsByUsername(Client client);
    
}
