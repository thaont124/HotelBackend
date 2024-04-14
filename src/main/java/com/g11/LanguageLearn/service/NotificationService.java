package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.SettingUpdateRequest;
import com.g11.LanguageLearn.dto.response.BillResponse;
import com.g11.LanguageLearn.dto.response.NotificationResponse;
import com.g11.LanguageLearn.dto.response.SettingResponse;
import com.g11.LanguageLearn.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getAllNoticationByUser(Integer idUser);

    BillResponse getDetailBill(Integer idNotification);

    SettingResponse getSetting(Integer idUser);

    SettingResponse updateSetting(Integer idUser, SettingUpdateRequest request);

    Notification patchType(Integer id);
}
