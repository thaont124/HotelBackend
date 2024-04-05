package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.service.ExchangeVoucherService;
import com.g11.LanguageLearn.service.VoucherService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiv1/")
public class ExchangeVoucherController {
    @Autowired
    private  ExchangeVoucherService exchangeVoucherService;
    @Autowired
    private VoucherService voucherService;
    @PatchMapping("exchangevoucher/{idUser}/{idVoucher}")
    public ResponseEntity<?> exchangeVoucher(@PathVariable("idUser") Integer idUser,@PathVariable("idVoucher") Integer idVoucher) throws BadRequestException {
         voucherService.exchangeVoucher(idUser,idVoucher);
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
