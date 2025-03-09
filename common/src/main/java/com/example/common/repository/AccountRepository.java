package com.example.common.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.domain.model.Account;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    
}
