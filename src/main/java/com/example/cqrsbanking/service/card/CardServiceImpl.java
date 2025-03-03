package com.example.cqrsbanking.service.card;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Card;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private CardQueryService queryService;
    private CardCommandService commandService;
    @Override
    public Card getById(UUID id) {
        return queryService.getById(id);
    }

    @Override
    public void create(Card object) {
        commandService.create(object);
    }
    
}
