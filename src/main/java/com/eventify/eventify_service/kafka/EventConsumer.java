package com.eventify.eventify_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.eventify.eventify_service.notification.NotificationService;

@Service
public class EventConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(
            topics = "event-created",
            groupId = "eventify-group")
    public void consume(String organizerId) {

        System.out.println(
                "EVENT RECEIVED : " + organizerId);

        notificationService.createNotification(
                organizerId,
                "Event created successfully");
    }
}