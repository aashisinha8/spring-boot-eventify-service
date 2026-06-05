package com.eventify.eventify_service.notification;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(
            String userId,
            String message) {

        Notification notification = new Notification();

        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setStatus("UNREAD");
        notification.setCreatedAt(LocalDateTime.now());

        return notificationRepository.save(notification);
    }

    public List<Notification> getNotifications(
            String userId) {

        return notificationRepository.findByUserId(userId);
    }
    public Notification markAsRead(String notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                        .orElseThrow(() ->
                                new RuntimeException("Notification not found"));

        notification.setStatus("READ");

        return notificationRepository.save(notification);
    }
}