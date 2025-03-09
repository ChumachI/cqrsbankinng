package com.example.common.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.events.AbstractEvent;

public interface EventRepository extends JpaRepository<AbstractEvent, Long> {

}
