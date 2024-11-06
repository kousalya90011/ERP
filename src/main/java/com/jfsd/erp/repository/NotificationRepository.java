package com.jfsd.erp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.erp.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>
{
	List<Notification> findByScheduledTimeBeforeAndPostedTimeIsNull(LocalDateTime now);
}
