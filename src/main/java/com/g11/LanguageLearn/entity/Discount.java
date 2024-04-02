package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiscount;

    private Integer discountValue;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "idRoom", nullable = false)
    private Room room;
}
