package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.*;
import com.g11.LanguageLearn.dto.response.LoginResponse;
import com.g11.LanguageLearn.dto.response.ProfileResponse;
import com.g11.LanguageLearn.dto.response.SaleResponse;
import com.g11.LanguageLearn.entity.Point;
import com.g11.LanguageLearn.entity.User;
import com.g11.LanguageLearn.repository.BookedRoomRepository;
import com.g11.LanguageLearn.repository.PointRepository;
import com.g11.LanguageLearn.repository.UserRepository;
import com.g11.LanguageLearn.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ProfileResponse getProfile(Integer id) {
        User user = userRepository.getById(id);
        return new ProfileResponse(user);
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



    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int addUser(RegistrationRequest registrationRequest){
        User user = new User(
                registrationRequest.getUsername(),
                this.passwordEncoder.encode(registrationRequest.getPassword()),
                registrationRequest.getEmail(),
                registrationRequest.getFirstName(),
                registrationRequest.getMiddleName(),
                registrationRequest.getLastName(),
                registrationRequest.getCccd(),
                registrationRequest.getPhoneNumber()


        );
        User savedUser = userRepository.save(user);
        return savedUser.getIdUser();
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest){
        String msg = "";
        User user1 = userRepository.findByUsername(loginRequest.getUsername());
        if (user1 != null){
            String password = loginRequest.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwdRight){
                Optional<User> user = userRepository.findOneByUsernameAndPassword(loginRequest.getUsername(), encodedPassword);
                if(user.isPresent()){
                    return new LoginResponse("Login Success", true);
                }else{
                    return new LoginResponse("Login Failed", false);

                }
            }else{
                return new LoginResponse("Password Not Match", false);
            }

        }else{
            return new LoginResponse("Username not exist", false);
        }
    }
}

