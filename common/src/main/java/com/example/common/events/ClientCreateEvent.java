package com.example.common.events;

import com.example.common.domain.aggregate.Aggregate;
import com.example.common.domain.model.Client;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientCreateEvent extends AbstractEvent {
    
    public ClientCreateEvent(Client playLoad) {
        super(null, EventType.CLIENT_CREATE, playLoad);
    }

    @Override
    public void apply(Aggregate aggregate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'apply'");
    }
}
