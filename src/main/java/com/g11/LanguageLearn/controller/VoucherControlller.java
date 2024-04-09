package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/apiv1")
@RestController
public class VoucherControlller {
    @Autowired
    private VoucherService voucherService;

    @GetMapping("/voucher")
    public ResponseEntity<?> getAllVoucher(){
        return new ResponseEntity<>(voucherService.getAllVoucher(), HttpStatus.OK);
    }

    @GetMapping("/voucher/{id}")
    public ResponseEntity<?> getMyVoucher(@PathVariable("id") Integer id){
        return new ResponseEntity<>(voucherService.getMyVoucher(id),HttpStatus.OK);
    }
}
