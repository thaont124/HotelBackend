package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookedRoomResponse {
    private String numberRoom;
    private String typeRoom;
    private String hotelName;
    private String  pricePerHour;
    private String pricePerDay;
}
