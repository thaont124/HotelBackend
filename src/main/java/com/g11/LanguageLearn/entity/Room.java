package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoom;

    private String roomNumber;

    private Float pricePerDay;

    private Float pricePerHour;

    @OneToOne
    private TypeRoom typeRoom;

    private String img;
}
