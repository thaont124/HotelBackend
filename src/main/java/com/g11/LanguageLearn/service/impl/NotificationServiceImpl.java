package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.NotificationResponse;
import com.g11.LanguageLearn.entity.Notification;
import com.g11.LanguageLearn.repository.NotificationRepository;
import com.g11.LanguageLearn.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<NotificationResponse> getAllNoticationByUser(Integer idUser) {
        List<Notification> notifications = notificationRepository.getNotificationByUserId(idUser);

        List<NotificationResponse> result = new ArrayList<>();
        for (Notification notification : notifications){
            result.add(new NotificationResponse(notification.getIdNotification(), notification.getContent(),
                    notification.getDateNotice().toString(), notification.getType()));
        }

        return result;
    }
}
