package org.training.springboot.data.rdv.rdvdemo.repository.heritage.joined;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.joined.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
