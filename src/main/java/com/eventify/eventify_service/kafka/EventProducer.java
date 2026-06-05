package com.eventify.eventify_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publishEvent(String organizerId) {

        kafkaTemplate.send(
                "event-created",
                organizerId);

        System.out.println(
                "EVENT PUBLISHED : " + organizerId);
    }
}