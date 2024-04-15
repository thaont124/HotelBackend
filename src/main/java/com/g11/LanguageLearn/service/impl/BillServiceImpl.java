package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.BillRequest;
import com.g11.LanguageLearn.dto.response.BillResponse;
import com.g11.LanguageLearn.dto.response.FeedbackResponse;
import com.g11.LanguageLearn.entity.Bill;
import com.g11.LanguageLearn.entity.User;
import com.g11.LanguageLearn.repository.BillRepository;
import com.g11.LanguageLearn.repository.UserRepository;
import com.g11.LanguageLearn.service.BillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private UserRepository userRepository;



    @Override
    public void createBill(BillRequest billRequest) {
        Bill bill = new Bill();
        bill.setCodeBill(billRequest.getCodeBill());
        bill.setTotalPrice(billRequest.getTotalPrice());
        bill.setDiscount(billRequest.getDiscount());
        bill.setVat(billRequest.getVat());
        bill.setStatus(billRequest.getStatus());
        bill.setUser(userRepository.getById(billRequest.getUserId())); // assuming you have a constructor in User class that accepts userId
        bill.setCheckin(LocalDate.parse(billRequest.getCheckin(), DateTimeFormatter.ISO_LOCAL_DATE));
        bill.setCheckout(LocalDate.parse(billRequest.getCheckout(), DateTimeFormatter.ISO_LOCAL_DATE));

        // Save the bill entity
        billRepository.save(bill);


    }
}
