package com.example.moizaspringserver.domain.notification.repository;

import com.example.moizaspringserver.domain.notification.entity.NotificationList;
import com.example.moizaspringserver.domain.notification.entity.NotificationListId;
import org.springframework.data.repository.CrudRepository;

public interface NotificationListRepository extends CrudRepository<NotificationList, NotificationListId> {
}
