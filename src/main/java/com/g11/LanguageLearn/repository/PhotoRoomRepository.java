package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.PhotoRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRoomRepository extends JpaRepository<PhotoRoom, Integer> {
}
