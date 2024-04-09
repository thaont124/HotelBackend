package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.BillResponse;
import com.g11.LanguageLearn.dto.response.NotificationResponse;
import com.g11.LanguageLearn.dto.response.SettingResponse;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getAllNoticationByUser(Integer idUser);

    BillResponse getDetailBill(Integer idNotification);

    SettingResponse getSetting(Integer idUser);
}
