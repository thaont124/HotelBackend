package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Photo;
import com.g11.LanguageLearn.entity.PhotoFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoFeedbackRepository extends JpaRepository<PhotoFeedback, Integer> {
    @Query("SELECT p FROM PhotoFeedback p WHERE p.feedback.idFeedback =:idFeedback")
    List<Photo> getPhotoByIdFeedback(@Param("idFeedback") Integer idFeedback);
}
