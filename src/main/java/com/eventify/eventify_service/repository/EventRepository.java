package com.eventify.eventify_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.eventify.eventify_service.model.Event;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {

    List<Event> findByOrganizerId(String organizerId);
}
