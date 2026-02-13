package com.eventify.eventify_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventify.eventify_service.model.Event;
import com.eventify.eventify_service.repository.EventRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getEventsByOrganizer(String organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
