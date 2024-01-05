package com.group6.Medalion.repository;

import com.group6.Medalion.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface for data access operations for Event entity
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Additional custom query methods can be added here if necessary
}
