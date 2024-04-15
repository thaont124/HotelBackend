package com.g11.LanguageLearn.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookedRoomRequest {
    private LocalDate checkin;

    private LocalDate checkout;
    private String statusPayment;
    private List<Integer> roomIds;
}
