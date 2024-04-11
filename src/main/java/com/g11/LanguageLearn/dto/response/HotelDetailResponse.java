package com.g11.LanguageLearn.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class HotelDetailResponse {
    private String hotelName;

    private Integer rate;

    List<PhotoResponse> photo;
}
