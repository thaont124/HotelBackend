package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.ExchangeVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExchangeVoucherRepository extends JpaRepository<ExchangeVoucher,Integer> {
    @Query("select e from ExchangeVoucher e where e.user.idUser =:id")
    List<ExchangeVoucher> getExchangeVouchersByIdUser(@Param("id") Integer id);
}
