package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.dto.response.RoomResponse;
import com.g11.LanguageLearn.dto.response.SearchResponse;
import com.g11.LanguageLearn.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RoomService {
    public List<SearchResponse> findAvailableRooms(String value, String checkin, String checkout);

    public List<RoomResponse> getRoom(Integer id, String checkin, String checkout,String value);
}
