package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;
public interface RoomService {
    public List<Room> findAvailableRooms(String value,SearchRequest searchRequest);
}
