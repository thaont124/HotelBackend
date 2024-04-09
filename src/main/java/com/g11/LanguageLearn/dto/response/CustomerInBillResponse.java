package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerInBillResponse {
    private String name;
    private String cccd;
    private String email;
    private String phoneNumber;
    private String dateBooking;
    private String dateCheckin;
    private String dateCheckout;
    private String statusPayment;
}
