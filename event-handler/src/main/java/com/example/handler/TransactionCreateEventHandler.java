package com.example.handler;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.example.common.domain.model.Transaction;
import com.example.common.events.TransactionCreateEvent;
import com.example.service.transaction.TransactionService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component("TRANSACTION_CREATE")
@RequiredArgsConstructor
public class TransactionCreateEventHandler implements EventHandler {
    private final TransactionService transactionService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        TransactionCreateEvent event = gson.fromJson(object, TransactionCreateEvent.class);
        Transaction transaction = gson.fromJson((String) event.getPayload(), Transaction.class);
        transactionService.create(transaction);
        acknowledgment.acknowledge();
    }
}
