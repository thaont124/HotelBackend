package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.ChangeCCCDRequest;
import com.g11.LanguageLearn.dto.request.ChangeEmailRequest;
import com.g11.LanguageLearn.dto.request.ChangePasswordRequest;
import com.g11.LanguageLearn.dto.request.ChangeSDTRequest;
import com.g11.LanguageLearn.dto.response.SaleResponse;
import com.g11.LanguageLearn.entity.Point;
import com.g11.LanguageLearn.entity.User;
import com.g11.LanguageLearn.repository.BookedRoomRepository;
import com.g11.LanguageLearn.repository.PointRepository;
import com.g11.LanguageLearn.repository.UserRepository;
import com.g11.LanguageLearn.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PointRepository pointRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BookedRoomRepository bookedRoomRepository;
    public void updatePassword(Integer id, ChangePasswordRequest request){
        User user = userRepository.getById(id);
        if(!user.getPassword().equals(request.getOldPassword())){
            try {
                throw new BadRequestException();
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }else {
            user.setPassword(request.getNewPassword());
            userRepository.save(user);
        }
    }
    public User getUserById(Integer id){
        User user = userRepository.getById(id);
        return user;
    }

    @Override
    public void updateSDT(Integer id, ChangeSDTRequest changeSDTRequest) {
        User user = userRepository.getById(id);
        user.setPhoneNumber(changeSDTRequest.getSdt());
        userRepository.save(user);
    }

    @Override
    public void updateEmail(Integer id, ChangeEmailRequest changeEmailRequest) {
        User user = userRepository.getById(id);
        user.setEmail(changeEmailRequest.getEmail());
        userRepository.save(user);
    }

    @Override
    public void updateCCCD(Integer id, ChangeCCCDRequest changeCCCDRequest) {
        User user = userRepository.getById(id);
        user.setCccd(changeCCCDRequest.getCccd());
        userRepository.save(user);
    }

    @Override
    public Point getLastPoint(Integer id) {
        return pointRepository.getLastPoint(id);
    }

    @Override
    public List<Point> getHistoryPoint(Integer id) {
        return pointRepository.getHistoryPoint(id);
    }

    @Override
    public SaleResponse getSales(Integer id) {
        Float total = bookedRoomRepository.getSales(id);
        SaleResponse saleResponse = new SaleResponse(total);
        return saleResponse;
    }
}
