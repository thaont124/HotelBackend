package com.g11.LanguageLearn.dto.response;

import com.g11.LanguageLearn.entity.User;
import lombok.Data;

@Data
public class ProfileResponse {
    private Integer idUser;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private String cccd;

    public ProfileResponse(User user) {
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.cccd = user.getCccd();
    }
}
