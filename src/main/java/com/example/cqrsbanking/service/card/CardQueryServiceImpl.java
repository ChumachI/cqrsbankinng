package com.example.cqrsbanking.service.card;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.exception.ResourceNotFoundException;
import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.repository.CardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    @Override
    public Card getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    
}
