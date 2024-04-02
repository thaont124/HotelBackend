package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBranch;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "idAddress")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "idHotel")
    private Hotel hotel;
}
