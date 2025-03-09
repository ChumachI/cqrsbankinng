package com.example.common.events;

import com.example.common.domain.aggregate.Aggregate;
import com.example.common.domain.model.Transaction;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TransactionCreateEvent extends AbstractEvent {
    
    public TransactionCreateEvent(Transaction playLoad) {
        super(null, EventType.TRANSACTION_CREATE, playLoad);
    }

    @Override
    public void apply(Aggregate aggregate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }
}
