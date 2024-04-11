package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.ExchangeVoucherRequest;
import com.g11.LanguageLearn.entity.ExchangeVoucher;
import com.g11.LanguageLearn.entity.Point;
import com.g11.LanguageLearn.entity.User;
import com.g11.LanguageLearn.entity.Voucher;
import com.g11.LanguageLearn.repository.ExchangeVoucherRepository;
import com.g11.LanguageLearn.repository.PointRepository;
import com.g11.LanguageLearn.repository.UserRepository;
import com.g11.LanguageLearn.repository.VoucherRepository;
import com.g11.LanguageLearn.service.VoucherService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherRepository voucherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private ExchangeVoucherRepository exchangeVoucherRepository;
    @Override
    public List<Voucher> getAllVoucher() {
        return voucherRepository.findAll();
    }


    @Override
    public void exchangeVoucher(Integer idUser, ExchangeVoucherRequest exchangeVoucherRequest) throws BadRequestException {
        User user = userRepository.getById(idUser);
        Voucher voucher = voucherRepository.getById(exchangeVoucherRequest.getId());
        Integer point = pointRepository.getLastPoint(idUser).getPoint();
        if(point<voucher.getPointVoucher()){
            throw new BadRequestException();
        }
        else{
            ExchangeVoucher exchangeVoucher = new ExchangeVoucher();
            exchangeVoucher.setUser(user);
            exchangeVoucher.setVoucher(voucher);
            exchangeVoucher.setStatusVoucher(0);
            exchangeVoucherRepository.save(exchangeVoucher);

            Point point1 =new Point();
            point1.setUser(user);
            point1.setStatusPoint(0);
            point1.setPoint(voucher.getPointVoucher());
            point1.setTotal(point-voucher.getPointVoucher());
            pointRepository.save(point1);
        }
    }
}
