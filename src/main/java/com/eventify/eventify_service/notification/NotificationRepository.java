package com.eventify.eventify_service.notification;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository
        extends MongoRepository<Notification, String> {

    List<Notification> findByUserId(String userId);
}