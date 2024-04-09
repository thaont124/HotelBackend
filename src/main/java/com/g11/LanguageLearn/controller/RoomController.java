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
    @GetMapping("/search/{value}")
    public ResponseEntity<?> getRoomSearch(@PathVariable("value") String value, @RequestBody SearchRequest searchRequest){
        List<Room> list = roomService.findAvailableRooms(value,searchRequest);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
