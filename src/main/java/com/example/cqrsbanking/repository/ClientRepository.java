package com.example.cqrsbanking.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cqrsbanking.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{

    boolean existsByUsername(String username);

    Optional<Client> getByUsername(String username);
    
}
