package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.dto.response.MyVoucherResponse;
import com.g11.LanguageLearn.entity.ExchangeVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface ExchangeVoucherRepository extends JpaRepository<ExchangeVoucher,Integer> {
//    @Query("select e.idExchangeVoucher,e.voucher.nameVoucher,e.voucher.pointVoucher,e.voucher.priceVoucher,e.statusVoucher from ExchangeVoucher e where e.user.idUser =:id order by e.idExchangeVoucher DESC")
//    List<MyVoucherResponse> getExchangeVouchersByIdUser(@Param("id") Integer id);
}
