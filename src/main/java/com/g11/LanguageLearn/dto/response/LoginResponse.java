package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data

@AllArgsConstructor
public class LoginResponse {
    int idUser;
    String message;

    public LoginResponse(Integer idUser, String message) {
        this.idUser = idUser;
        this.message = message;
    }
    public LoginResponse(String message) {
        this.message = message;
    }


}

