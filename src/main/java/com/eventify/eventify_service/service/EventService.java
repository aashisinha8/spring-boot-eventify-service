package com.eventify.eventify_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.eventify.eventify_service.kafka.EventProducer;
import org.springframework.stereotype.Service;
import com.eventify.eventify_service.model.Event;

import com.eventify.eventify_service.repository.EventRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {

        Event savedEvent = eventRepository.save(event);

        eventProducer.publishEvent(
                event.getOrganizerId()
        );

        return savedEvent;
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