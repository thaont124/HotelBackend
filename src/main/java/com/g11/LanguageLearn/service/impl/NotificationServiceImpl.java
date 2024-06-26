package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.SettingUpdateRequest;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
        Collections.sort(result, new Comparator<NotificationResponse>() {
            @Override
            public int compare(NotificationResponse o1, NotificationResponse o2) {
                LocalDateTime date1 = LocalDateTime.parse(o1.getDateNotice());
                LocalDateTime date2 = LocalDateTime.parse(o2.getDateNotice());
                // Sử dụng compareTo để so sánh ngày
                return date2.compareTo(date1);
            }
        });
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

    @Override
    public SettingResponse updateSetting(Integer idUser, SettingUpdateRequest request) {
        NotificationSetting setting = notificationSettingRepository.getNotificationSettingByUserId(idUser);
        setting.setNoticeCheckin(request.getNoticeCheckin());
        setting.setTimeBeforeCheckin(request.getTimeBeforeCheckin());
        setting.setNoticePoint(request.getNoticePoint());
        NotificationSetting savedSetting = notificationSettingRepository.save(setting);
        SettingResponse settingResponse = new SettingResponse(savedSetting.getNoticeCheckin(),
                savedSetting.getTimeBeforeCheckin(), savedSetting.getNoticePoint());
        return settingResponse;
    }

    @Override
    public Notification patchType(Integer id) {
        Optional<Notification> optionalNotification = notificationRepository.findById(id);
        if (!optionalNotification.isPresent()){
            throw new BaseException(404, "NOT_FOUND", "Notification with id " + id + " not found");
        }
        Notification notification = optionalNotification.get();
        notification.setType("1");
        Notification savedNotification = notificationRepository.save(notification);
        return savedNotification;
    }
}
