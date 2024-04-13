package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.SuggestionBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionHotelRepository extends JpaRepository<SuggestionBranch, Integer> {
}
