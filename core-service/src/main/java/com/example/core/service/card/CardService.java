package com.example.core.service.card;

import java.util.UUID;

import com.example.common.domain.model.Card;
import com.example.core.service.CommandService;
import com.example.core.service.QueryService;

public interface CardService extends QueryService<Card>, CommandService<Card> {

    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
    
}
