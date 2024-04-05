package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.service.RoomService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class RoomServcieImpl implements RoomService {

    @Autowired
    private EntityManager entityManager;

//    @Override
//    public List<Room> findAvailableRooms(String value,SearchRequest searchRequest) {
//        LocalDateTime CHECKIN = searchRequest.getCheckin();
//        LocalDateTime CHECKOUT = searchRequest.getCheckout();
//        Query query = entityManager.createQuery(
//                "SELECT r FROM Room r WHERE (r.branch.hotel.nameHotel like :value or r.branch.address like :value) and (  r.idRoom NOT IN (SELECT DISTINCT br.room.idRoom FROM BookedRoom br WHERE (:CHECKIN BETWEEN br.checkin AND DATE_SUB(br.checkout, INTERVAL 1 DAY) OR :CHECKOUT BETWEEN DATE_ADD(br.checkin, INTERVAL 1 DAY) AND br.checkout) OR (:CHECKIN < br.checkin AND :CHECKOUT > br.checkout))".formatted()
//        );
//        query.setParameter("CHECKIN", CHECKIN);
//        query.setParameter("CHECKOUT", CHECKOUT);
//        query.setParameter("value", value);
//        return query.getResultList();
//    }


    @Override
    public List<Room> findAvailableRooms(String value,SearchRequest searchRequest) {

        LocalDateTime IN = searchRequest.getCheckin();
        LocalDateTime OUT = searchRequest.getCheckout();
        Query query = entityManager.createQuery(
                "SELECT r FROM Room r " +
                        "WHERE (r.branch.hotel.nameHotel LIKE :value) " +
                        "AND r.idRoom NOT IN (" +
                        "    SELECT DISTINCT br.room.idRoom " +
                        "    FROM BookedRoom br " +
                        "    WHERE (br.checkout BETWEEN :CHECKIN AND :CHECKOUT OR br.checkin BETWEEN :CHECKIN AND :CHECKOUT)" +
                        "          OR (:CHECKIN < br.checkin AND :CHECKOUT > br.checkout)" +
                        ")"
        );
        query.setParameter("value", "%" + value + "%");
        query.setParameter("CHECKIN", IN);
        query.setParameter("CHECKOUT", OUT);

        return query.getResultList();
    }

    @Override
    public List<Room> sort(List<Room> list) {
        return null;
    }

}
