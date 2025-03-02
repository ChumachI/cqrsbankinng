package com.example.cqrsbanking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cqrsbanking.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID>{
    
}
