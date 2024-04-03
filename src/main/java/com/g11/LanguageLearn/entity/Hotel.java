package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHotel;

    private String nameHotel;

}
