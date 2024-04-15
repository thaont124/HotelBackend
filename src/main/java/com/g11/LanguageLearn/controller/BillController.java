package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.request.BillRequest;
import com.g11.LanguageLearn.dto.response.BillResponse;
import com.g11.LanguageLearn.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1/bill")
public class BillController {
    @Autowired
    private BillService billService;


    @PostMapping("create")
    public ResponseEntity<?> createBill(@Validated @RequestBody BillRequest billRequest) {
        billService.createBill(billRequest);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
