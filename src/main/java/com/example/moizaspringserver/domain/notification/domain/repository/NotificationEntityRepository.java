package com.example.moizaspringserver.domain.notification.domain.repository;

import com.example.moizaspringserver.domain.notification.domain.entity.NotificationEntity;
import org.springframework.data.repository.CrudRepository;

public interface NotificationEntityRepository extends CrudRepository<NotificationEntity, Long> {
}
