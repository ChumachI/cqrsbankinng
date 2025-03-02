package com.example.cqrsbanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cqrsbanking.events.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {
    
}
