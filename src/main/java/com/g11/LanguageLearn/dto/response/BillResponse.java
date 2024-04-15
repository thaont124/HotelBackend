package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BillResponse {
    private String billCode;
    private String totalPrice;
    private String discount;
    private String vat;
    private String gross;

    private List<BookedRoomResponse> room;

    private CustomerInBillResponse customer;

    public BillResponse() {

    }
}
