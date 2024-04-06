package com.g11.LanguageLearn.dto.response;

import com.g11.LanguageLearn.entity.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class NotificationResponse {
    private Integer idNotification;

    private String content;

    private String dateNotice;

    private String type;
}
