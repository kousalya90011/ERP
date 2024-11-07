package com.jfsd.erp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jfsd.erp.models.Notification;
import com.jfsd.erp.repository.NotificationRepository;

@Service
public class NotificationScheduler {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationService notificationService;
  
    @Scheduled(fixedRate = 60000)
    public void sendScheduledNotifications() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Checking notifications at " + now);

        // Fetch notifications that are due and not yet sent
        List<Notification> dueNotifications = notificationRepository.findByScheduledTimeBeforeAndPostedTimeIsNull(now);
        System.out.println("Found " + dueNotifications.size() + " notifications due for sending");

        for (Notification notification : dueNotifications) {
            // Print the notification message to the console
            notificationService.sendNotification(notification);

            // Mark the notification as sent
            String formattedTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            notification.setPostedTime(formattedTime);
            notificationRepository.save(notification);

            System.out.println("Notification sent and updated in database: " + notification.getMesg());
        }
    }
}
