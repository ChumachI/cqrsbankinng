package com.example.cqrsbanking.service.event;

import com.example.cqrsbanking.events.AbstractEvent;

public interface EventService {
    void create(AbstractEvent events);
}
