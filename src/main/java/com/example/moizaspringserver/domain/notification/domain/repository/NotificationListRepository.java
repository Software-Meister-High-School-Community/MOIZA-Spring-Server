package com.example.moizaspringserver.domain.notification.domain.repository;

import com.example.moizaspringserver.domain.notification.domain.entity.NotificationList;
import com.example.moizaspringserver.domain.notification.domain.entity.NotificationListId;
import org.springframework.data.repository.CrudRepository;

public interface NotificationListRepository extends CrudRepository<NotificationList, NotificationListId> {
}
