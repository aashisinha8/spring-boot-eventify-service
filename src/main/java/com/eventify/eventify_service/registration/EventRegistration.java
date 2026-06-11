package com.eventify.eventify_service.registration;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registrations")
public class EventRegistration {

    @Id
    private String id;

    private String eventId;

    private String participantId;

    private LocalDateTime registeredAt;

    public EventRegistration() {
    }

    public String getId() {
        return id;
    }

    public String getEventId() {
        return eventId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}