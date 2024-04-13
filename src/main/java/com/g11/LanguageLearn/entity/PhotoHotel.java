package com.g11.LanguageLearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class PhotoHotel extends Photo{
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    public PhotoHotel(String uri, String type, Hotel hotel) {
        super(uri, type);
        this.hotel = hotel;
    }
}

