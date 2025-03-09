package com.example.core.web.security.service;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.common.domain.exception.ResourceNotFoundException;
import com.example.common.domain.model.Card;
import com.example.common.domain.model.Client;
import com.example.common.domain.model.Transaction;
import com.example.core.service.card.CardService;
import com.example.core.service.client.ClientService;
import com.example.core.service.transaction.TransactionService;
import com.example.core.web.security.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final ClientService clientService;
    private final TransactionService transactionService;
    private final CardService cardService;

    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.isAuthenticated()) {
            return null;
        }
        if(authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (SecurityUser) authentication.getPrincipal();
    }

    @Override
    public boolean canAccessClient(UUID clientId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        return clientId.equals(id);
    }

    @Override
    public boolean canAccessCard(UUID cardId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        return  client.getCards().stream().anyMatch(card -> card.getId().equals(cardId));
    }

    @Override
    public boolean canAccessCard(Card card) {
        try {
            Card foundCard = cardService.getByNumberAndDateAndCvv(card.getNumber(), card.getDate(), card.getCvv());
            return canAccessCard(foundCard.getId());
        } catch (ResourceNotFoundException e) {
            return false;
        }
    }

    @Override
    public boolean canAccessTransaction(UUID transactionId) {
        SecurityUser user = getUserFromRequest();
        UUID id = user.getId();
        Client client = clientService.getById(id);
        Transaction transaction = transactionService.getById(transactionId);
        var clientCards = client.getCards();
        return clientCards.contains(transaction.getFrom()) || clientCards.contains(transaction.getTo());
    }
}