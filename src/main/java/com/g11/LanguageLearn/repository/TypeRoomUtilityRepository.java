package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.TypeRoomUtility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRoomUtilityRepository extends JpaRepository<TypeRoomUtility, Integer> {
}
