package com.g11.LanguageLearn.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchRequest {
    private LocalDateTime checkin;
    private LocalDateTime checkout;
}
