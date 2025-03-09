package com.example.core.web.security.service;

import java.util.UUID;

import com.example.common.domain.model.Card;
import com.example.core.web.security.SecurityUser;

public interface SecurityService {

    SecurityUser getUserFromRequest();
    boolean canAccessClient(UUID clientId);
    boolean canAccessCard(UUID cardId);
    boolean canAccessCard(Card card);
    boolean canAccessTransaction(UUID transactionId);
}
