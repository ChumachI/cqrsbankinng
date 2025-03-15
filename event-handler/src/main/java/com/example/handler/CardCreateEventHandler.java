package com.example.handler;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.example.common.domain.model.Card;
import com.example.common.events.CardCreateEvent;
import com.example.service.card.CardService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component("CARD_CREATE")
@RequiredArgsConstructor
public class CardCreateEventHandler implements EventHandler {

    private final CardService cardService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        CardCreateEvent event = gson.fromJson(object, CardCreateEvent.class);
        Card card = gson.fromJson((String) event.getPayload(), Card.class);
        cardService.create(card);
        acknowledgment.acknowledge();
    }
    
}
