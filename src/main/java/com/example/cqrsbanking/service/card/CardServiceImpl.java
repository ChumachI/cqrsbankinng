package com.example.cqrsbanking.service.card;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.client.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardQueryService queryService;
    private final CardCommandService commandService;
    private final ClientService clientService;
    @Override
    public Card getById(UUID id) {
        return queryService.getById(id);
    }


    @Override
    public void createByClientId(UUID id) {
        Client client = clientService.getById(id);
        Card card = new Card(client.getAccount());
        commandService.create(card);
    }

    @Override
    public void create(Card object) {
        commandService.create(object);
    }


    @Override
    public boolean existsByNumberAndDate(String number, String date) {
        return queryService.existsByNumberAndDate(number, date);
    }


    @Override
    public Card getByNumberAndDateAndCvv(String number, String date, String cvv) {
        return queryService.getByNumberAndDateAndCvv(number, date, cvv);
    }
}
