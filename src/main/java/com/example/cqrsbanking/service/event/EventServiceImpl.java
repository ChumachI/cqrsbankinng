package com.example.cqrsbanking.service.event;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.events.AbstractEvent;
import com.example.cqrsbanking.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Override
    public void create(AbstractEvent event) {
        repository.save(event);
    }
    
}
