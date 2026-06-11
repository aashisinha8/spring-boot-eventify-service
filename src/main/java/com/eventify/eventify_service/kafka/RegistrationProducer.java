package com.eventify.eventify_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegistrationProducer {

    private static final String TOPIC =
            "registration-created";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishRegistration(String eventId) {

        kafkaTemplate.send(TOPIC, eventId);

        System.out.println(
                "REGISTRATION PUBLISHED : " + eventId);
    }
}