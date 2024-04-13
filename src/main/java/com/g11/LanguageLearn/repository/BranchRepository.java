package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Branch;
import com.g11.LanguageLearn.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository <Branch, Integer>{
    @Query("SELECT b FROM Branch b join SuggestionBranch sb ON sb.branch.idBranch = b.idBranch where sb.suggestion.idSuggestion=:idSuggestion")
    List<Branch> getListBySuggestionID(@Param("idSuggestion") Integer idSuggestion);

    @Query("SELECT b FROM Branch b JOIN SuggestionBranch sb JOIN Suggestion s JOIN Room r JOIN TypeRoom tr JOIN Utility u WHERE s.idSuggestion = :suggestionId AND u.nameUtility IN :selectedUtilities GROUP BY b HAVING COUNT(DISTINCT u) = :numSelectedUtilities")
    List<Branch> findBranchesBySelectedUtilities(Suggestion suggestion, @Param("selectedUtilities") List<String> selectedUtilities, @Param("numSelectedUtilities") int numSelectedUtilities);
}
