package com.example.service.card;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.common.domain.model.Card;

public interface CardService {
    
    Card getById(UUID id);

    Card create(Card card);

    void add(Card card, BigDecimal amount);

    void addTransaction(UUID cardId, UUID transactionId);
}
