package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.SearchRequest;
import com.g11.LanguageLearn.dto.response.MyVoucherResponse;
import com.g11.LanguageLearn.dto.response.RoomResponse;
import com.g11.LanguageLearn.dto.response.SearchResponse;
import com.g11.LanguageLearn.entity.Room;
import com.g11.LanguageLearn.repository.FeedbackRepository;
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

    @Autowired
    private FeedbackRepository feedbackRepository;


    @Override
    public List<SearchResponse> findAvailableRooms(String value, String checkin, String checkout) {

        LocalDate IN = LocalDate.parse(checkin);
        LocalDate OUT = LocalDate.parse(checkout);
        Query query = entityManager.createQuery(
                "SELECT DISTINCT b.idBranch, b.hotel.nameHotel, b.address.district, b.address.city, b.address.province,b.price " +
                        "FROM Branch b " +
                        "INNER JOIN Room r ON b.idBranch = r.branch.idBranch " +
                        "WHERE (b.hotel.nameHotel like :value or b.address.city like :value or b.address.province like :value) AND EXISTS (" +
                        "    SELECT 1 FROM Room r2 " +
                        "    LEFT JOIN BookedRoom br ON r2.idRoom = br.room.idRoom " +
                        "    WHERE r2.branch.idBranch = b.idBranch " +
                        "    AND ((br.bill.checkin > :CHECKOUT OR br.bill.checkout < :CHECKIN) OR br.room.idRoom IS NULL)" +
                        ")"
        );
        query.setParameter("value", "%" + value + "%");
        query.setParameter("CHECKIN", IN);
        query.setParameter("CHECKOUT", OUT);

        List<SearchResponse> myVoucherResponses = new ArrayList<>();
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            float a = feedbackRepository.getFeedbackByBranch((Integer) result[0]);
            SearchResponse bran = new SearchResponse((Integer) result[0],(String) result[1],(String) result[2],(String) result[3],(String) result[4],a,(Float) result[5]);

            myVoucherResponses.add(bran);
        }

        return myVoucherResponses;
    }

    @Override
    public List<RoomResponse> getRoom(Integer id, String checkin, String checkout) {
        LocalDate IN = LocalDate.parse(checkin);
        LocalDate OUT = LocalDate.parse(checkout);
        Query query = entityManager.createQuery(
                "SELECT r.idRoom,r.roomNumber,r.typeRoom.nameTypeRoom,r.pricePerDay " +
                        "FROM Room r " +
                        "LEFT JOIN BookedRoom br ON r.idRoom = br.room.idRoom " +
                        "WHERE r.branch.idBranch = 1 " +
                        "AND ((br.bill.checkin > :CHECKOUT OR br.bill.checkout < :CHECKIN) OR br.room.idRoom IS NULL)"
        );


        query.setParameter("CHECKIN", IN);
        query.setParameter("CHECKOUT", OUT);

        List<RoomResponse> myVoucherResponses = new ArrayList<>();
        List<Object[]> results = query.getResultList();

        for (Object[] result : results) {
            RoomResponse bran = new RoomResponse((Integer) result[0],(String) result[1],(String) result[2],(Float) result[3]);

            myVoucherResponses.add(bran);
        }

        return myVoucherResponses;
    }


}
