package com.example.service.card;

import org.springframework.stereotype.Service;

import com.example.common.domain.model.Card;
import com.example.common.repository.CardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardRepository repository;

    @Override
    public Card create(Card card) {
        //TODO set number, date and cvv
        return repository.save(card);
    }
    
}
