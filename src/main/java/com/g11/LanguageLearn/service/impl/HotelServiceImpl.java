package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.HotelResponse;
import com.g11.LanguageLearn.entity.Hotel;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.HotelRepository;
import com.g11.LanguageLearn.repository.SuggestionRepository;
import com.g11.LanguageLearn.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl  implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private SuggestionRepository suggestionRepository;

    public List<HotelResponse> getList(Integer idSuggestion){
        List<Hotel> hotels = hotelRepository.getListBySuggestionID(idSuggestion);
        if(!suggestionRepository.existsById(idSuggestion)){
            throw new NotFoundException();
        }

        //chuyển đổi sang response trả ra fe
        List<HotelResponse> result = new ArrayList<>();
        for (Hotel hotel : hotels){
            HotelResponse hotelResponse = new HotelResponse();
            hotelResponse.setNameHotel(hotel.getNameHotel());

            result.add(hotelResponse);
        }

        return result;
    }


}
