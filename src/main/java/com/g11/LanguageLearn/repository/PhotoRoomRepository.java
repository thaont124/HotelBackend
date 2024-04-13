package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Photo;
import com.g11.LanguageLearn.entity.PhotoRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRoomRepository extends JpaRepository<PhotoRoom, Integer> {
    @Query("SELECT p FROM PhotoRoom p WHERE p.room.idRoom =:idBranch")
    List<Photo> getPhotoByIdRoom(@Param("idBranch") Integer idBranch);
}
