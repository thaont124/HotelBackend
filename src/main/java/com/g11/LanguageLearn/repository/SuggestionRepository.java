package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {
}
