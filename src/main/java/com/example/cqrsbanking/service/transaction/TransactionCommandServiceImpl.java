package com.example.cqrsbanking.service.transaction;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Transaction;
import com.example.cqrsbanking.events.TransactionCreateEvent;
import com.example.cqrsbanking.service.event.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final EventService eventService;

    @Override
    public void create(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
    
}
