package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Hotel;
import com.g11.LanguageLearn.entity.SuggestionHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {
    @Query("SELECT h FROM Hotel h join SuggestionHotel sh ON sh.hotel.idHotel = h.idHotel where sh.suggestion.idSuggestion=:idSuggestion")
    List<Hotel> getListBySuggestionID(@Param("idSuggestion") Integer idSuggestion);
}
