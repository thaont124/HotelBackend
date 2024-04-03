package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.entity.ExchangeVoucher;
import com.g11.LanguageLearn.repository.ExchangeVoucherRepository;
import com.g11.LanguageLearn.service.ExchangeVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeVoucherServiceImpl implements ExchangeVoucherService {
    @Autowired
    private ExchangeVoucherRepository exchangeVoucherRepository;
    @Override
    public List<ExchangeVoucher> getByIdUser(Integer idUser) {
        return exchangeVoucherRepository.getExchangeVouchersByIdUser(idUser);
    }
}
