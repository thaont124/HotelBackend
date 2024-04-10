package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.ChangePasswordRequest;
import com.g11.LanguageLearn.dto.response.MyVoucherResponse;
import com.g11.LanguageLearn.entity.ExchangeVoucher;

import java.util.List;

public interface ExchangeVoucherService {
    List<MyVoucherResponse> getMyVoucher(Integer idUser);


}
