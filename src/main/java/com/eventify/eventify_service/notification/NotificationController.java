package com.eventify.eventify_service.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{userId}")
    public List<Notification> getNotifications(
            @PathVariable String userId) {

        return notificationService.getNotifications(userId);
    }
    @PutMapping("/{notificationId}/read")
    public Notification markAsRead(
            @PathVariable String notificationId) {

        return notificationService.markAsRead(notificationId);
    }
}
