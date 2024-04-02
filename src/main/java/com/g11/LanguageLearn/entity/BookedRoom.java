package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBookedRoom;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "idRoom")
    private Room room;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    private String statusPayment;

}
