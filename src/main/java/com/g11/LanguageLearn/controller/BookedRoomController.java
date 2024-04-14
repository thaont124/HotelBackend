package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.response.BookedRoomResponse;
import com.g11.LanguageLearn.dto.response.UtilityResponse;
import com.g11.LanguageLearn.service.BookedRoomService;
import com.g11.LanguageLearn.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apiv1/booked")
public class BookedRoomController {
    @Autowired
    private BookedRoomService bookedRoomService;

    @GetMapping("getList/{idUser}")
    public ResponseEntity<?> getList(@PathVariable("idUser") Integer idUser){
        System.out.println("idUser " + idUser);
        List<BookedRoomResponse> list = bookedRoomService.getList(idUser);
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
