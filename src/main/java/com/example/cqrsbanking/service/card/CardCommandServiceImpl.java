package com.example.cqrsbanking.service.card;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.events.CardCreateEvent;
import com.example.cqrsbanking.service.event.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardCommandServiceImpl implements CardCommandService {

    private final EventService eventService;

    @Override
    public void create(Card object) {
        CardCreateEvent event = new CardCreateEvent(object);
        eventService.create(event);
    }
    
}
