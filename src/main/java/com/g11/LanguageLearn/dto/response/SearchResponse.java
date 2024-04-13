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

    private Float rate;

    private Float price;

    private String image;

}
