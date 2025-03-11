package com.example.handler;

import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.example.common.domain.model.Account;
import com.example.common.events.AccountCreateEvent;
import com.example.service.account.AccountService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component("COMPONENT_CREATE")
@RequiredArgsConstructor
public class AccountCreateEventHandler implements EventHandler {

    private final AccountService accountService;
    private final Gson gson;

    @Override
    @Transactional
    public void handle(JsonObject object, Acknowledgment acknowledgment) {
        AccountCreateEvent event = gson.fromJson(object, AccountCreateEvent.class);
        Account account = gson.fromJson((String) event.getPayload(), Account.class);
        accountService.create(account);
        acknowledgment.acknowledge();
    }
    
}
