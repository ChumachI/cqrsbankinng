package com.example.cqrsbanking.service.client;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.events.ClientCreateEvent;
import com.example.cqrsbanking.service.event.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientCommandServiceImpl implements ClientCommandService {

    private final EventService eventService;

    @Override
    public void create(Client object) {
        ClientCreateEvent event = new ClientCreateEvent(object);
        eventService.create(event);
    }
    
}
