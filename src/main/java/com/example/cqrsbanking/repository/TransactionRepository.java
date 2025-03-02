package com.example.cqrsbanking.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cqrsbanking.domain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    
}
