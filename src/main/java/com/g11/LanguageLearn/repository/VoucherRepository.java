package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.ExchangeVoucher;
import com.g11.LanguageLearn.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher,Integer> {


}
