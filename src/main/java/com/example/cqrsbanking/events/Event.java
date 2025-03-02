package com.example.cqrsbanking.events;

import com.example.cqrsbanking.domain.aggregate.Aggregate;

public interface Event {
    void apply(Aggregate aggregate);
}
