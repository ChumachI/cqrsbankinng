package com.example.cqrsbanking.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.service.client.ClientService;
import com.example.cqrsbanking.web.dto.AccountDto;
import com.example.cqrsbanking.web.dto.CardDto;
import com.example.cqrsbanking.web.dto.ClientDto;
import com.example.cqrsbanking.web.dto.mapper.AccountMapper;
import com.example.cqrsbanking.web.dto.mapper.CardMapper;
import com.example.cqrsbanking.web.dto.mapper.ClientMapper;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public ClientDto getById(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);
    }

    @GetMapping("/{id}/cards")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public List<CardDto> getCardsByClientId(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return cardMapper.toDto(client.getCards());
    }

    @GetMapping("/{id}/account")
    @PreAuthorize("@ssi.canAccessClient(#id)")
    public AccountDto getAccountByClientId(@PathVariable final UUID id) {
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }
}
