package com.example.cqrsbanking.service.card;

import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.service.CommandService;
import com.example.cqrsbanking.service.QueryService;

public interface CardService extends QueryService<Card>, CommandService<Card> {
    
}
