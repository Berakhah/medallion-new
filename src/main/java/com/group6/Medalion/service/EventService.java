package com.group6.Medalion.service;

import com.group6.Medalion.entity.Event;
import com.group6.Medalion.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service for managing Event-related operations
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    // Save a new event
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // Retrieve an event by ID
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    // Retrieve all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Delete an event by ID
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
