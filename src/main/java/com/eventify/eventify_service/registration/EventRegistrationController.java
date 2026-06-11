package com.eventify.eventify_service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
public class EventRegistrationController {

    @Autowired
    private EventRegistrationService registrationService;

    @PostMapping("/{eventId}/{participantId}")
    public EventRegistration registerForEvent(
            @PathVariable String eventId,
            @PathVariable String participantId) {

        return registrationService.register(
                eventId,
                participantId);
    }
}