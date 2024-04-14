package com.g11.LanguageLearn.repository;

import com.g11.LanguageLearn.entity.BookedRoom;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.entity.Utility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookedRoomRepository extends JpaRepository<BookedRoom,Integer> {
    @Query("select sum (br.bill.totalPrice) from BookedRoom br where br.bill.user.idUser =:id and extract(month from br.bill.checkin) = extract(month from current date )")
    Float getSales(@Param("id") Integer id);

    @Query("select br from BookedRoom br where br.bill.idBill = :idBill")
    List<BookedRoom> getRoomInBill(@Param("idBill") Integer idBill);

    @Query("SELECT br.room FROM BookedRoom br WHERE br.bill.user.idUser = :idUser")
    List<Room> findBookedRoomsByUserId(@Param("idUser") Integer userId);


}
