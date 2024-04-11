package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.PhotoHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoHotelRepository extends JpaRepository<PhotoHotel, Integer> {
}
