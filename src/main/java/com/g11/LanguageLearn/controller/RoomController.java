package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.dto.response.RoomResponse;
import com.g11.LanguageLearn.dto.response.SearchResponse;
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
    @GetMapping ("/search/{value}")
    public ResponseEntity<?> getBranchSearch(@PathVariable("value") String value,@RequestParam("checkin") String checkin,@RequestParam("checkout") String checkout){
        List<SearchResponse> list = roomService.findAvailableRooms(value,checkin,checkout);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/searchroom/{id}")
    public ResponseEntity<?> getRoomSearch(@PathVariable("id") Integer id,@RequestParam("checkin") String checkin,@RequestParam("checkout") String checkout){
        List<RoomResponse> list = roomService.getRoom(id,checkin,checkout);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
