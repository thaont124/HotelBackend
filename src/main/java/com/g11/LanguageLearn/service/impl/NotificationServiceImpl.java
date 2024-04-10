package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.*;
import com.g11.LanguageLearn.entity.*;
import com.g11.LanguageLearn.exception.base.BadRequestException;
import com.g11.LanguageLearn.exception.base.BaseException;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.BookedRoomRepository;
import com.g11.LanguageLearn.repository.NotificationRepository;
import com.g11.LanguageLearn.repository.NotificationSettingRepository;
import com.g11.LanguageLearn.repository.UserRepository;
import com.g11.LanguageLearn.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private BookedRoomRepository bookedRoomRepository;

    @Autowired
    private NotificationSettingRepository notificationSettingRepository;

    @Override
    public List<NotificationResponse> getAllNoticationByUser(Integer idUser) {
        List<Notification> notifications = notificationRepository.getNotificationByUserId(idUser);

        List<NotificationResponse> result = new ArrayList<>();
        for (Notification notification : notifications){
            result.add(new NotificationResponse(notification.getIdNotification(), notification.getContent(),
                    notification.getDateNotice().toString(), notification.getType()));
        }

        return result;
    }

    @Override
    public BillResponse getDetailBill(Integer idNotification) {

        Notification notification = notificationRepository.getById(idNotification);
        if (notification == null) {
            throw new NotFoundException();
        }
        Bill bill = notification.getBill();
        User user= notification.getUser();
        List<BookedRoom> rooms = bookedRoomRepository.getRoomInBill(bill.getIdBill());

        //return
        CustomerInBillResponse customer = new CustomerInBillResponse(user.getFullName(), user.getCccd(),
                user.getEmail(), user.getPhoneNumber(), bill.getCheckin().toString(),
                bill.getCheckin().toString(), bill.getCheckout().toString(), bill.getStatusString());

        List<BookedRoomResponse> roomsResponse = new ArrayList<>();

        for (BookedRoom bookedRoom : rooms){
            roomsResponse.add(new BookedRoomResponse(bookedRoom.getRoom().getRoomNumber(),
                    bookedRoom.getRoom().getTypeRoom().getNameTypeRoom(),
                    bookedRoom.getRoom().getBranch().getHotel().getNameHotel(),
                    bookedRoom.getRoom().getPricePerHour().toString(),
                    bookedRoom.getRoom().getPricePerDay().toString()));
        }

        return new BillResponse(bill.getCodeBill(), bill.getTotalPrice().toString(),
                bill.getDiscount().toString(), bill.getVat().toString(),
                String.valueOf(bill.getTotalPrice() + bill.getVat() - bill.getDiscount()),
                roomsResponse, customer);
    }

    @Override
    public SettingResponse getSetting(Integer idUser) {
        Optional<User> userOptional = userRepository.findById(idUser);
        if (userOptional.isEmpty()){
            throw new BaseException(404, "NOT_FOUND", "User is unavailable");
        }
        NotificationSetting setting = notificationSettingRepository.getNotificationSettingByUserId(idUser);
        if (setting == null){
            throw new BaseException(400, "BAD_REQUEST", "No setting");
        }
        SettingResponse settingResponse = new SettingResponse(setting.getNoticeCheckin(),
                setting.getTimeBeforeCheckin(), setting.getNoticePoint());
        return settingResponse;

    }
}
