package com.example.service.client;

import java.util.UUID;

import com.example.common.domain.model.Client;

public interface ClientService {
    Client create(Client client);

    void addCard(UUID clientId, UUID cardId);
}
