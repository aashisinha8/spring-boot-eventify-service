package com.eventify.eventify_service.notification;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface NotificationRepository
        extends MongoRepository<Notification, String> {

    List<Notification> findByUserId(String userId);
   
}