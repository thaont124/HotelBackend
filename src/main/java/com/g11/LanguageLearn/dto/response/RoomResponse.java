package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomResponse {
    private Integer idRoom;
    private String numberRoom;
    private String typeRoom;
    private Float pricePerDay;

}
