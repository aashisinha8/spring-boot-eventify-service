package com.eventify.eventify_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.eventify.eventify_service.model.Event;
import com.eventify.eventify_service.notification.NotificationService;
import com.eventify.eventify_service.repository.EventRepository;

@Service
public class RegistrationConsumer {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(
            topics = "registration-created",
            groupId = "eventify-group")
    public void consumeRegistration(String eventId) {

        System.out.println(
                "REGISTRATION RECEIVED : " + eventId);

        Event event =
                eventRepository.findById(eventId)
                        .orElse(null);

        if (event == null) {
            System.out.println(
                    "Event not found : " + eventId);
            return;
        }

        notificationService.createNotification(
                event.getOrganizerId(),
                "New participant registered for your event"
        );

        System.out.println(
                "Organizer notified : "
                        + event.getOrganizerId());
    }
}