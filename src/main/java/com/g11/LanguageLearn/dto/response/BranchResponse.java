package com.g11.LanguageLearn.dto.response;

import lombok.Data;

@Data
public class BranchResponse {
    private Float price;
    private HotelResponse hotelResponse;
    private AddressResponse addressResponse;
    private Float rate;
}
