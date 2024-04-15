package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.BookedRoomRequest;
import com.g11.LanguageLearn.dto.response.BookedRoomResponse;
import com.g11.LanguageLearn.entity.Bill;
import com.g11.LanguageLearn.entity.BookedRoom;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.entity.User;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.BillRepository;
import com.g11.LanguageLearn.repository.BookedRoomRepository;
import com.g11.LanguageLearn.repository.RoomRepository;
import com.g11.LanguageLearn.repository.UserRepository;
import com.g11.LanguageLearn.service.BookedRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookedServiceImpl implements BookedRoomService {
    @Autowired //tiêm interface repo
    private BookedRoomRepository bookedRoomRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BillRepository billRepository;


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

    @Override
    public void bookRooms(Integer idBill, BookedRoomRequest bookedRoomRequest) {
        for (int i=0;i<bookedRoomRequest.getRoomIds().size();i++){
            BookedRoom bookedRoom = new BookedRoom();
            Bill bill = billRepository.getById(idBill);
            bookedRoom.setRoom(roomRepository.getById(bookedRoomRequest.getRoomIds().get(i)));
            bookedRoom.setBill(billRepository.getById(idBill));
            bookedRoom.setStatusPayment("chưa thanh toan");
            bookedRoom.setBill(bill);
            bookedRoomRepository.save(bookedRoom);
        }

    }


}
