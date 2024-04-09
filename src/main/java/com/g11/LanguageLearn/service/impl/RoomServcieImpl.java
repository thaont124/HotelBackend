package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.service.RoomService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class RoomServcieImpl implements RoomService {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Room> findAvailableRooms(String value,SearchRequest searchRequest) {

        LocalDate IN = LocalDate.parse(searchRequest.getCheckin());
        LocalDate OUT = LocalDate.parse(searchRequest.getCheckout());
        Query query = entityManager.createQuery(
                "SELECT r FROM Room r " +
                        "WHERE (r.branch.hotel.nameHotel LIKE :value) " +
                        "AND r.idRoom NOT IN (" +
                        "    SELECT DISTINCT br.room.idRoom " +
                        "    FROM BookedRoom br " +
                        "    WHERE (br.bill.checkout BETWEEN :CHECKIN AND :CHECKOUT OR br.bill.chekcin BETWEEN :CHECKIN AND :CHECKOUT)" +
                        "          OR (:CHECKIN < br.bill.chekcin AND :CHECKOUT > br.bill.checkout)" +
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
