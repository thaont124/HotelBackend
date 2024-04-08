package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.TypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRoomRepository extends JpaRepository<TypeRoom, Integer> {
}
