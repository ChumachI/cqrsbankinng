package com.example.core.service.client;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.common.domain.exception.ResourceNotFoundException;
import com.example.common.domain.model.Client;
import com.example.common.repository.ClientRepository;

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

    @Override
    public Client getByUsername(String username) {
        return repository.getByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }
    
}
