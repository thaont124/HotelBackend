package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.NotificationResponse;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getAllNoticationByUser(Integer idUser);

}
