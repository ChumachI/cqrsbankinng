package com.example.cqrsbanking.web.controller;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrsbanking.domain.model.Transaction;
import com.example.cqrsbanking.service.card.CardService;
import com.example.cqrsbanking.service.transaction.TransactionService;
import com.example.cqrsbanking.web.dto.OnCreate;
import com.example.cqrsbanking.web.dto.TransactionDto;
import com.example.cqrsbanking.web.dto.mapper.TransactionMapper;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    @PreAuthorize("@ssi.canAccessCard(#dto.from)")
    public void createTransaction(
        @RequestBody @Validated(OnCreate.class) final TransactionDto dto
        ) {
        if(!cardService.existsByNumberAndDate(dto.getTo().getNumber(), dto.getTo().getDate())) {
            throw new IllegalStateException("Card does not exists.");
        }
        Transaction transaction = transactionMapper.fromDto(dto);
        transactionService.create(transaction);
    }
    
    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTransaction(#id)")
    public TransactionDto getById(@PathVariable final UUID id) {
        Transaction transaction = transactionService.getById(id);
        return transactionMapper.toDto(transaction);
    }
    
}
