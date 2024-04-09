package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("select a from Address a join Branch b on b.address.idAddress = a.idAddress where b.idBranch = :idBranch")
    Address getAddressByIdBranch(@Param("idBranch") Integer idBranch);
}
