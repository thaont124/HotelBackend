package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.MyVoucherResponse;
import com.g11.LanguageLearn.entity.ExchangeVoucher;
import com.g11.LanguageLearn.repository.ExchangeVoucherRepository;
import com.g11.LanguageLearn.service.ExchangeVoucherService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeVoucherServiceImpl implements ExchangeVoucherService {
    @Autowired
    private ExchangeVoucherRepository exchangeVoucherRepository;
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<MyVoucherResponse> getMyVoucher(Integer idUser) {
        Query query =entityManager.createQuery(
                "SELECT e.idExchangeVoucher,e.voucher.nameVoucher,e.voucher.pointVoucher,e.voucher.priceVoucher,e.statusVoucher from ExchangeVoucher e " +
                        "WHERE e.user.idUser =:id order by e.idExchangeVoucher DESC "
        );
        query.setParameter("id", idUser);
        return query.getResultList();

//        List<MyVoucherResponse> list =  exchangeVoucherRepository.getExchangeVouchersByIdUser(idUser);
//        return list;
    }
}
