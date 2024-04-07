package com.g11.LanguageLearn.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBill;

    private String codeBill;

    private Float totalPrice;

    private Float discount;

    private Float vat;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "idUser")
    private User user;

    private LocalDateTime checkin;

    private LocalDateTime checkout;

    public String getStatusString(){
        return this.status == 1 ? "Đã thanh toán" : "Chưa thanh toán";
    }
}
