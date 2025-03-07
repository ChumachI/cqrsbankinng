package com.example.cqrsbanking.service.card;

import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.service.QueryService;

public interface CardQueryService extends QueryService<Card> {

    boolean existsByNumberAndDate(String number, String date);

    Card getByNumberAndDateAndCvv(String number, String date, String cvv);
    
}
