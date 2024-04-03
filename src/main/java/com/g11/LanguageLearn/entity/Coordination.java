package com.g11.LanguageLearn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Coordination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCoordination;

    private Float latitude; //vi do

    private Float longitude; //kinh do
}
