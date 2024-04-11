package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SuggestionHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSuggestionHotel;

    @ManyToOne
    @JoinColumn(name = "suggestion_id", referencedColumnName = "idSuggestion")
    private Suggestion suggestion;
    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "idHotel")
    private Hotel hotel;
}
