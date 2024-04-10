package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSuggestion;

    private String nameSuggestion;
}
