package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiv1")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping ("/search/{value}?checkin={checkin}?chekcout={checkout}")
    public ResponseEntity<?> getRoomSearch(@PathVariable("value") String value,@PathVariable("checkin") String checkin,@PathVariable("checkout") String checkout){
        List<Room> list = roomService.findAvailableRooms(value,checkin,checkout);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
