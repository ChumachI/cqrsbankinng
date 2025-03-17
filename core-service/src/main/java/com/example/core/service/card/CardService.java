package com.example.core.service.card;

import java.util.UUID;

import com.example.common.domain.model.Card;
import com.example.common.service.QueryService;
import com.example.core.service.CommandService;

public interface CardService extends QueryService<Card>, CommandService<Card> {

    void createByClientId(UUID id);

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);

    Card getByNumberAndDate(String number, String date);
    
}
