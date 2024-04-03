package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBill;

    private Float totalPrice;

    private Float vat;

    private Integer status;


}
