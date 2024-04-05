package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookedRoomRepository extends JpaRepository<BookedRoom,Integer> {
    @Query("select sum (br.bill.totalPrice) from BookedRoom br where br.user.idUser =:id and extract(month from br.checkin) = extract(month from current date )")
    Float getSales(@Param("id") Integer id);
}
