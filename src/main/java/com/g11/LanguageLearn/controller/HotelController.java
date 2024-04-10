package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.response.HotelResponse;
import com.g11.LanguageLearn.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("apiv1/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("getList/{idSuggestion}")
    public ResponseEntity<?> getList(@PathVariable("idSuggestion") Integer idSuggestion){
        List<HotelResponse> list = hotelService.getList(idSuggestion);
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
