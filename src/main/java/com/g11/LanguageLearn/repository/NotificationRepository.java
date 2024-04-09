package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query("select n from Notification n where n.user.idUser =:idUser")
    List<Notification> getNotificationByUserId(@Param("idUser") Integer idUser);

}
