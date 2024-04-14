package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.BookedRoomResponse;

import java.util.List;

public interface BookedRoomService {
    List<BookedRoomResponse> getList(Integer idUser);
}
