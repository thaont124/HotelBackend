package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.BookedRoomRequest;
import com.g11.LanguageLearn.dto.response.BookedRoomResponse;
import com.g11.LanguageLearn.entity.BookedRoom;

import java.util.List;

public interface BookedRoomService {
    List<BookedRoomResponse> getList(Integer idUser);

    public void bookRooms(Integer idBill,BookedRoomRequest bookedRoomRequest);
}
