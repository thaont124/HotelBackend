package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.PhotoFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoFeedbackRepository extends JpaRepository<PhotoFeedback, Integer> {
}
