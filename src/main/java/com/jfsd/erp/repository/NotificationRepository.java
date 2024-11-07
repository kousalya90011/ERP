package com.jfsd.erp.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jfsd.erp.models.Admin;
import com.jfsd.erp.models.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
   // List<Notification> findByScheduledTimeBeforeAndPostedTimeIsNull(LocalDateTime scheduledTime);
	//@Query("select a from Notification a where a.scheduledTime =?1")
	//public List<Notification> findByScheduledTimeBeforeAndPostedTimeIsNull(LocalDateTime scheduledTime);

	 @Query("SELECT a FROM Notification a WHERE a.scheduledTime <= ?1")
	    List<Notification> findByScheduledTimeBeforeAndPostedTimeIsNull(LocalDateTime scheduledTime);
}
