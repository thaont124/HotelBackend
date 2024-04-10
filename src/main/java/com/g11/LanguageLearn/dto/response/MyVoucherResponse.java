package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyVoucherResponse {
    private String nameVoucher;

    private Integer id;

    private Integer point;

    private Integer price;

    private Integer status;

}
