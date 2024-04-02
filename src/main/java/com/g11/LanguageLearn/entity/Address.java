package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAddress;

    private String numberHouse;

    private String district;

    private String city;

    private String province;

    @OneToOne
    @JoinColumn(name = "coordination_id", referencedColumnName = "idCoordination")
    private Coordination coordination;
}
