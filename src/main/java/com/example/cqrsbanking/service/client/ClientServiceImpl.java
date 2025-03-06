package com.example.cqrsbanking.service.client;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Client;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientQueryService queryService;
    private final ClientCommandService commandService;
    
    @Override
    public Client getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void create(Client object) {
        commandService.create(object);
    }

    @Override 
    public boolean existsByUsername(Client client) {
        return queryService.existsByUsername(client);
    }

    @Override
    public Client getByUsername(String username) {
        return queryService.getByUsername(username);
    }
    
}
