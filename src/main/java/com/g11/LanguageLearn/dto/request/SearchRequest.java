package com.g11.LanguageLearn.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SearchRequest {
    private LocalDateTime checkin;
    private LocalDateTime checkout;
}
