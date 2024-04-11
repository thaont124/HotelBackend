package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchResponse {
    private Integer idBranch;

    private String nameHotel;

    private String district;

    private String city;

    private String province;

    private Integer rate;

    private Float price;
}
