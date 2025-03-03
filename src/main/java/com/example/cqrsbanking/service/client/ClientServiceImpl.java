package com.example.cqrsbanking.service.client;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Client;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientQueryService queryService;
    private ClientCommandService commandService;
    @Override
    public Client getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void create(Client object) {
        commandService.create(object);
    }
    
}
