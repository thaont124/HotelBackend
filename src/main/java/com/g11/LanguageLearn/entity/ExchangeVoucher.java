package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ExchangeVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExchangeVoucher;

    @ManyToOne
    @JoinColumn(name = "voucher_id", referencedColumnName = "idVoucher")
    private Voucher voucher;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    private Integer statusVoucher;
}
