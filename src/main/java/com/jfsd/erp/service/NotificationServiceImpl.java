package com.jfsd.erp.service;

import org.springframework.stereotype.Service;
import com.jfsd.erp.models.Notification;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(Notification notification) {
        // Simulate sending notification (prints to console)
        System.out.println("Sending notification: " + notification.getMesg() + " to " + notification.getRole());
    }
}
