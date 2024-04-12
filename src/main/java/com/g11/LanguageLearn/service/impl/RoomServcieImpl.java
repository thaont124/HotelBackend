package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.dto.response.MyVoucherResponse;
import com.g11.LanguageLearn.dto.response.RoomResponse;
import com.g11.LanguageLearn.dto.response.SearchResponse;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.service.RoomService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class RoomServcieImpl implements RoomService {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<SearchResponse> findAvailableRooms(String value, String checkin, String checkout) {

        LocalDate IN = LocalDate.parse(checkin);
        LocalDate OUT = LocalDate.parse(checkout);
        Query query = entityManager.createQuery(
                "SELECT b.idBranch, b.hotel.nameHotel, b.address.district, b.address.city, b.address.province, r.pricePerDay  FROM Branch b " +
                        "JOIN Room r ON r.branch.idBranch = b.idBranch " +
                        "WHERE (b.hotel.nameHotel LIKE :value) " +
                        "AND r.idRoom NOT IN (" +
                        "    SELECT DISTINCT br.room.idRoom " +
                        "    FROM BookedRoom br " +
                        "    WHERE (br.bill.checkout BETWEEN :CHECKIN AND :CHECKOUT OR br.bill.checkin BETWEEN :CHECKIN AND :CHECKOUT)" +
                        "          OR (:CHECKIN < br.bill.checkin AND :CHECKOUT > br.bill.checkout)" +
                        ")"
        );
        query.setParameter("value", "%" + value + "%");
        query.setParameter("CHECKIN", IN);
        query.setParameter("CHECKOUT", OUT);

        List<SearchResponse> myVoucherResponses = new ArrayList<>();
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            SearchResponse bran = new SearchResponse((Integer) result[0],(String) result[1],(String) result[2],(String) result[3],(String) result[4],(Integer) result[5],(Float) result[6]);

            myVoucherResponses.add(bran);
        }

        return myVoucherResponses;
    }

    @Override
    public List<RoomResponse> getRoom(Integer id, String checkin, String checkout) {
        LocalDate IN = LocalDate.parse(checkin);
        LocalDate OUT = LocalDate.parse(checkout);
        Query query = entityManager.createQuery(
                "SELECT r FROM Room r" +
                        " where r.idRoom NOT IN (" +
                        "    SELECT DISTINCT br.room.idRoom " +
                        "    FROM BookedRoom br " +
                        "    WHERE (br.bill.checkout BETWEEN :CHECKIN AND :CHECKOUT OR br.bill.checkin BETWEEN :CHECKIN AND :CHECKOUT)" +
                        "          OR (:CHECKIN < br.bill.checkin AND :CHECKOUT > br.bill.checkout)" +
                        ")"
        );
        query.setParameter("CHECKIN", IN);
        query.setParameter("CHECKOUT", OUT);

        return query.getResultList();
    }


}
