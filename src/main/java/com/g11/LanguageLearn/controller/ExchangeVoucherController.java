package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.request.ExchangeVoucherRequest;
import com.g11.LanguageLearn.service.ExchangeVoucherService;
import com.g11.LanguageLearn.service.VoucherService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiv1")
public class ExchangeVoucherController {
    @Autowired
    private  ExchangeVoucherService exchangeVoucherService;
    @Autowired
    private VoucherService voucherService;
    @PostMapping("/exchangevoucher/{idUser}")
    public ResponseEntity<?> exchangeVoucher(@PathVariable("idUser") Integer idUser, @RequestBody ExchangeVoucherRequest exchangeVoucherRequest) throws BadRequestException {
         voucherService.exchangeVoucher(idUser,exchangeVoucherRequest);
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
