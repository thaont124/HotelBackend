package com.g11.LanguageLearn.dto.request;

import lombok.Data;

@Data
public class BillRequest {
    private String codeBill;
    private Float totalPrice;
    private Float discount;
    private Float vat;
    private Integer status;
    private Integer userId;
    private String checkin;
    private String checkout;
}
