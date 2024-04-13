package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository <Branch, Integer>{
    @Query("SELECT AVG(r.pricePerDay) FROM Room r WHERE r.branch.idBranch = :branchId")
    Float getAveragePricePerDayByBranchId(@Param("branchId") Integer branchId);
}
