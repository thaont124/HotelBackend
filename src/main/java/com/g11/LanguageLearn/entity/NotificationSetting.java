package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSetting;

    private Integer noticeCheckin; //chi co 0 va 1

    private Integer timeBeforeCheckin; //bao truoc gio checkin

    private Integer noticePoint; //chi co 0 va 1

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
