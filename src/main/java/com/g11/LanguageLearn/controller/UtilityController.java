package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; //khai báo cái trả ra v nó tự động chuyển thành json
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; //trn đường dẫn có thứ cần dùng
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1/utility")
public class UtilityController {

    @Autowired
    private UtilityService utilityService;

    @GetMapping("getList/{idTypeRoom}")
    public ResponseEntity<?> getList(@PathVariable("idTypeRoom") Integer idTypeRoom){
        return new ResponseEntity<>(utilityService.getList(idTypeRoom), HttpStatus.OK);

    }
}