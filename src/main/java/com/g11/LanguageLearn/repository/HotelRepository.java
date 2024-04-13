package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {

}
