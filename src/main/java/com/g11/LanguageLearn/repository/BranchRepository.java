package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository <Branch, Integer>{

}
