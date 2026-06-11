package com.eventify.eventify_service.registration;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventify.eventify_service.kafka.RegistrationProducer;

@Service
public class EventRegistrationService {

    @Autowired
    private EventRegistrationRepository repository;

    @Autowired
    private RegistrationProducer registrationProducer;

    public EventRegistration register(
            String eventId,
            String participantId) {

        Optional<EventRegistration> existing =
                repository.findByEventIdAndParticipantId(
                        eventId,
                        participantId);

        if (existing.isPresent()) {
            throw new RuntimeException(
                    "Participant already registered");
        }

        EventRegistration registration =
                new EventRegistration();

        registration.setEventId(eventId);
        registration.setParticipantId(participantId);
        registration.setRegisteredAt(LocalDateTime.now());

        EventRegistration saved =
                repository.save(registration);

        // Publish event to Kafka
        registrationProducer.publishRegistration(
                eventId);

        return saved;
    }
}