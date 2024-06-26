package com.g11.LanguageLearn.service;


import com.g11.LanguageLearn.dto.request.*;
import com.g11.LanguageLearn.dto.response.LoginResponse;
import com.g11.LanguageLearn.dto.response.ProfileResponse;
import com.g11.LanguageLearn.dto.response.SaleResponse;
import com.g11.LanguageLearn.entity.Point;
import com.g11.LanguageLearn.entity.User;

import java.util.List;

public interface UserService {
    public void updatePassword(Integer id, ChangePasswordRequest request);
    public User getUserById(Integer id);

    ProfileResponse getProfile(Integer id);

    public void updateSDT(Integer id, ChangeSDTRequest changeSDTRequest);

    public void updateEmail(Integer id, ChangeEmailRequest changeEmailRequest);

    public void updateCCCD(Integer id, ChangeCCCDRequest changeCCCDRequest);

    public Point getLastPoint(Integer id);

    public List<Point> getHistoryPoint(Integer id);

    public SaleResponse getSales(Integer id);


    int addUser(RegistrationRequest registrationRequest);


    LoginResponse loginUser(LoginRequest loginRequest);
}
