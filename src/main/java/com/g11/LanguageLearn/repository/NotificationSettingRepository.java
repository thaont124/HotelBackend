package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.NotificationSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationSettingRepository extends JpaRepository<NotificationSetting, Integer> {
    @Query("select ns from NotificationSetting ns where ns.user.idUser = :userId")
    NotificationSetting getNotificationSettingByUserId(@Param("userId") Integer userId);
}
