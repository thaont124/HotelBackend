package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.repository.AddressRepository;
import com.g11.LanguageLearn.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1/hotel")
public class HotelController {
    @Autowired
    private AddressService addressService;


    @GetMapping("address/{idBranch}")
    public ResponseEntity<?> getAddressByBranchId(@PathVariable("idBranch") Integer idBranch){
        return new ResponseEntity<>(addressService.getAddressByIdBranch(idBranch), HttpStatus.OK);
    }
}
