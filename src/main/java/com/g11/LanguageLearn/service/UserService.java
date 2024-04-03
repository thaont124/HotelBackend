package com.g11.LanguageLearn.service;


import com.g11.LanguageLearn.dto.request.ChangeCCCDRequest;
import com.g11.LanguageLearn.dto.request.ChangeEmailRequest;
import com.g11.LanguageLearn.dto.request.ChangePasswordRequest;
import com.g11.LanguageLearn.dto.request.ChangeSDTRequest;
import com.g11.LanguageLearn.entity.Point;
import com.g11.LanguageLearn.entity.User;

import java.util.List;

public interface UserService {
    public void updatePassword(Integer id, ChangePasswordRequest request);
    public User getUserById(Integer id);

    public void updateSDT(Integer id, ChangeSDTRequest changeSDTRequest);

    public void updateEmail(Integer id, ChangeEmailRequest changeEmailRequest);

    public void updateCCCD(Integer id, ChangeCCCDRequest changeCCCDRequest);

    public Point getLastPoint(Integer id);

    public List<Point> getHistoryPoint(Integer id);
}
