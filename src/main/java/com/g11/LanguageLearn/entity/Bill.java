package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBill;

    private Float totalPrice;

    private Float vat;

    @OneToMany
    @JoinColumn(name = "booked_room_id", referencedColumnName = "idBookedRomm")
    private List<BookedRoom> bookedRoom;

    @OneToOne
    @JoinColumn(name = "feedback_id", referencedColumnName = "idFeedback")
    private Feedback feedback;
}
