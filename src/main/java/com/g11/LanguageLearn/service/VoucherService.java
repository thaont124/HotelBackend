package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.ExchangeVoucherRequest;
import com.g11.LanguageLearn.entity.ExchangeVoucher;
import com.g11.LanguageLearn.entity.Voucher;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface VoucherService {
    public List<Voucher> getAllVoucher();



    public void exchangeVoucher(Integer idUser, ExchangeVoucherRequest exchangeVoucherRequest) ;
}