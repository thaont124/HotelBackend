package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Branch;
import com.g11.LanguageLearn.entity.Hotel;
import com.g11.LanguageLearn.entity.SuggestionBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {
    @Query("SELECT h FROM Branch h join SuggestionBranch sh ON sh.branch.idBranch = h.idBranch where sh.suggestion.idSuggestion=:idSuggestion")
    List<Branch> getListBySuggestionID(@Param("idSuggestion") Integer idSuggestion);
}
