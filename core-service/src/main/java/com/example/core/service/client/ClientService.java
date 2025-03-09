package com.example.core.service.client;

import com.example.common.domain.model.Client;
import com.example.core.service.CommandService;
import com.example.core.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {

    boolean existsByUsername(Client client);

    Client getByUsername(String username);
    
}
