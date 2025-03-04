package com.example.cqrsbanking.service.client;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.exception.ResourceNotFoundException;
import com.example.cqrsbanking.domain.model.Client;
import com.example.cqrsbanking.repository.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientQueryServiceImpl implements ClientQueryService {

    private final ClientRepository repository;

    @Override
    public Client getById(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(Client client) {
        return repository.existsByUsername(client.getUsername());
    }
    
}
