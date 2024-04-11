package com.g11.LanguageLearn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class LoginResponse {
    Integer idUser;
    String message;
    Boolean status;
}
