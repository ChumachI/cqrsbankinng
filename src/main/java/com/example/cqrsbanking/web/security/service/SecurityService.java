package com.example.cqrsbanking.web.security.service;

import java.util.UUID;

import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.web.security.SecurityUser;

public interface SecurityService {

    SecurityUser getUserFromRequest();
    boolean canAccessClient(UUID clientId);
    boolean canAccessCard(UUID cardId);
    boolean canAccessCard(Card card);
    boolean canAccessTransaction(UUID transactionId);
}
