package com.example.service.client;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.common.domain.model.Account;
import com.example.common.domain.model.Client;
import com.example.common.repository.ClientRepository;
import com.example.service.account.AccountService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final AccountService accountService;

    @Override
    @Transactional
    public Client create(
            final Client client
    ) {
        Account account = new Account();
        account = accountService.create(account);
        client.setAccount(account);
        return repository.save(client);
    }

    @Override
    @Transactional
    public void addCard(
            final UUID clientId,
            final UUID cardId
    ) {
        repository.addCard(
                clientId.toString(),
                cardId.toString()
        );
    }
    
}
