package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBookedRoom;

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "idRoom")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "idBill")
    private Bill bill;
    private String statusPayment;
}
