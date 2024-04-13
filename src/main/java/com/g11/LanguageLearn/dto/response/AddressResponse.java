package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResponse {
    private String address;

    private Float latitude; //vi do

    private Float longitude; //kinh do

    public AddressResponse() {

    }
}
