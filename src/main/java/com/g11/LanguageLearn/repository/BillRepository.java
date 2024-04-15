package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    Bill save(Bill bill);
}
