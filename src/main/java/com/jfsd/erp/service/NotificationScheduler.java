package com.jfsd.erp.service;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Notification;
import com.jfsd.erp.repository.NotificationRepository;
import com.jfsd.erp.service.NotificationService;

@Service
public class NotificationScheduler {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationService notificationService;

    // Run every minute to check for due notifications
    @Scheduled(fixedRate = 60000)
    public void sendScheduledNotifications() {
        LocalDateTime now = LocalDateTime.now();
        
        // Fetch notifications that are due and not yet sent
        List<Notification> dueNotifications = notificationRepository.findByScheduledTimeBeforeAndPostedTimeIsNull(now);
        
        for (Notification notification : dueNotifications) {
            // Send the notification (implement the actual send logic in notificationService)
            notificationService.sendNotification(notification);
            
            // Mark as sent by setting the posted time
            notification.setPostedTime(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            notificationRepository.save(notification);
        }
    }
}
