package com.g11.LanguageLearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhoto;
    private String uri;
    private String type;

    public Photo(String uri, String type) {
        this.uri = uri;
        this.type = type;
    }
}
