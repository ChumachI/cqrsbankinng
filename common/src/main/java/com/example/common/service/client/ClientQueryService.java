package com.example.common.service.client;

import java.util.UUID;

import com.example.common.domain.model.Client;
import com.example.common.service.QueryService;

public interface ClientQueryService extends QueryService<Client> {

    Client getByUsername(String username);

    boolean existsByUsername(String username);

    Client getByAccount(UUID accountId);
    
}
