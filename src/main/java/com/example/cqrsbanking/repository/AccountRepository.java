package com.example.cqrsbanking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cqrsbanking.domain.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    
}
