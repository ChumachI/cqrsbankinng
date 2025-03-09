package com.example.common.events;

import com.example.common.domain.aggregate.Aggregate;
import com.example.common.domain.model.Account;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountCreateEvent extends AbstractEvent {
    
    public AccountCreateEvent(Account playLoad) {
        super(null, EventType.ACCOUNT_CREATE, playLoad);
    }

    @Override
    public void apply(Aggregate aggregate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }
}
