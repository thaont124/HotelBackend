package com.g11.LanguageLearn.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RegistrationRequest {
    private int idUser;

    private String username;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String cccd;

}

