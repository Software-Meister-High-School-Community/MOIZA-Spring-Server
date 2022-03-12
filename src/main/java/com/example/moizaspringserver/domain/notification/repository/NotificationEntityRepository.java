package com.example.moizaspringserver.domain.notification.repository;

import com.example.moizaspringserver.domain.notification.entity.NotificationEntity;
import org.springframework.data.repository.CrudRepository;

public interface NotificationEntityRepository extends CrudRepository<NotificationEntity, Integer> {
}
