package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotification;

    private String content;

    private LocalDateTime dateNotice;

    private String type;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

}
