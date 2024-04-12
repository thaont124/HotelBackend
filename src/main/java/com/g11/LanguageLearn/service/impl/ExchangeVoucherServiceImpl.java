package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.MyVoucherResponse;
import com.g11.LanguageLearn.entity.ExchangeVoucher;
import com.g11.LanguageLearn.repository.ExchangeVoucherRepository;
import com.g11.LanguageLearn.service.ExchangeVoucherService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        List<MyVoucherResponse> myVoucherResponses = new ArrayList<>();
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            MyVoucherResponse myVoucherResponse = new MyVoucherResponse((String) result[1],(Integer) result[0],(Integer) result[2],(Integer) result[3],(Integer) result[4]);
            // Thực hiện ánh xạ các giá trị từ kết quả truy vấn vào đối tượng MyVoucherResponse
//            myVoucherResponse.setId((Integer) result[0]); // Giả sử idExchangeVoucher là Long
//            myVoucherResponse.setNameVoucher((String) result[1]); // Giả sử nameVoucher là String
//            myVoucherResponse.setPoint((Integer) result[2]); // Giả sử pointVoucher là Integer
//            myVoucherResponse.setPrice((Integer) result[3]); // Giả sử priceVoucher là BigDecimal
//            myVoucherResponse.setStatus((Integer) result[4]); // Giả sử statusVoucher là String

            myVoucherResponses.add(myVoucherResponse);
        }

        return myVoucherResponses;

    }
}
