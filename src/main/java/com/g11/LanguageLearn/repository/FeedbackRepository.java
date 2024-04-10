package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

    @Query("SELECT f FROM Feedback f where f.branch.idBranch=:idBranch")
    List<Feedback> getListByBranchID(@Param("idBranch") Integer idBranch);
}
