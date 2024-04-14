package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.BookedRoomResponse;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.BookedRoomRepository;
import com.g11.LanguageLearn.repository.UserRepository;
import com.g11.LanguageLearn.service.BookedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookedServiceImpl implements BookedRoomService {
    @Autowired //tiêm interface repo
    private BookedRoomRepository bookedRoomRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BookedRoomResponse> getList(Integer idUser){
        List<Room> rooms = bookedRoomRepository.findBookedRoomsByUserId(idUser);
        if(!userRepository.existsById(idUser)){
            throw new NotFoundException();
        }

        //chuyển đổi sang response trả ra fe
        List<BookedRoomResponse> result = new ArrayList<>();
        for (Room room : rooms){
            BookedRoomResponse bookedRoomResponse = new BookedRoomResponse();
            bookedRoomResponse.setNumberRoom(room.getRoomNumber());
            bookedRoomResponse.setTypeRoom(room.getTypeRoom().getNameTypeRoom());
            bookedRoomResponse.setHotelName(room.getBranch().getHotel().getNameHotel());
            bookedRoomResponse.setPricePerDay(room.getPricePerDay().toString());
            result.add(bookedRoomResponse);
        }

        return result;
    }
}
