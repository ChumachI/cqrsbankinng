package com.example.cqrsbanking.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cqrsbanking.domain.model.Card;

public interface CardRepository extends JpaRepository<Card, UUID>{

    boolean existsByNumberAndDate(String number, String date);

    Optional<Card> findByNumberAndDateAndCvv(String number, String date, String cvv);
    
}
