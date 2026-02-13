package com.eventify.eventify_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventify.eventify_service.model.Event;
import com.eventify.eventify_service.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }

    @GetMapping("/organizer/{organizerId}")
    public List<Event> getByOrganizer(@PathVariable String organizerId) {
        return eventService.getEventsByOrganizer(organizerId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully";
    }
}
