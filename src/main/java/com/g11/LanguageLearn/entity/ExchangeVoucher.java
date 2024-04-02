package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;

@Entity
public class ExchangeVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExchangeVoucher;

    @ManyToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "idVoucher")
    private Voucher voucher;
    @ManyToOne
    @JoinColumn(name = "point_id", referencedColumnName = "idPoint")
    private Point point;

    private Integer statusVoucher;
}
