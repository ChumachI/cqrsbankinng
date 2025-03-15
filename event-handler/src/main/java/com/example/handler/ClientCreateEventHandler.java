package com.example.handler;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.example.common.domain.model.Client;
import com.example.common.events.ClientCreateEvent;
import com.example.service.client.ClientService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component("CLIENT_CREATE")
@RequiredArgsConstructor
public class ClientCreateEventHandler implements EventHandler {
    private final ClientService clientService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        ClientCreateEvent event = gson.fromJson(object, ClientCreateEvent.class);
        Client client = gson.fromJson((String) event.getPayload(), Client.class);
        clientService.create(client);
        acknowledgment.acknowledge();
    }
}
