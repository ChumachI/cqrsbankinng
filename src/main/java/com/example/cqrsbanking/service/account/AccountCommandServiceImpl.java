package com.example.cqrsbanking.service.account;

import org.springframework.stereotype.Service;

import com.example.cqrsbanking.domain.model.Account;
import com.example.cqrsbanking.events.AccountCreateEvent;
import com.example.cqrsbanking.service.event.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService {

    private final EventService eventService;

    @Override
    public void create(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
    
}
