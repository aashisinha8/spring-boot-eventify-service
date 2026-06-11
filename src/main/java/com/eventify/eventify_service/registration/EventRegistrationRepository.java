package com.eventify.eventify_service.registration;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRegistrationRepository
extends MongoRepository<EventRegistration, String> {

List<EventRegistration> findByEventId(String eventId);

List<EventRegistration> findByParticipantId(String participantId);

Optional<EventRegistration>
findByEventIdAndParticipantId(
    String eventId,
    String participantId);
}