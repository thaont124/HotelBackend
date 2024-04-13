package com.g11.LanguageLearn.dto.response;

import lombok.Data;

@Data
public class HotelResponse {
    private String nameHotel;
    private Integer level;
    private Float rate;
    private Float price;
    private String image;
}
