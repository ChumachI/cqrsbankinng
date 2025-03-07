package com.example.cqrsbanking.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrsbanking.domain.model.Card;
import com.example.cqrsbanking.service.card.CardService;
import com.example.cqrsbanking.web.dto.CardDto;
import com.example.cqrsbanking.web.dto.TransactionDto;
import com.example.cqrsbanking.web.dto.mapper.CardMapper;
import com.example.cqrsbanking.web.dto.mapper.TransactionMapper;
import com.example.cqrsbanking.web.security.SecurityUser;
import com.example.cqrsbanking.web.security.service.SecurityService;

import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;
    private final SecurityService securityService;

    @PostMapping
    public void create() {
        SecurityUser user = securityService.getUserFromRequest();
        cardService.createByClientId(user.getId());
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return cardMapper.toDto(card);
    }
    

    @GetMapping("/{id}/transactions")
    @PreAuthorize("@ssi.canAccessCard(#id)")
    public List<TransactionDto> getTransactions(@PathVariable final UUID id) {
        Card card = cardService.getById(id);
        return transactionMapper.toDto(card.getTransactions());
    }
    
    
}
