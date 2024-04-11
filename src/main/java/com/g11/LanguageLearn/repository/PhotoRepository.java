package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    @Query("select p from PhotoHotel p where p.hotel.idHotel = :idHotel")
    List<Photo> getPhotoByIdHotel(@Param("idHotel") Integer idHotel);
}
