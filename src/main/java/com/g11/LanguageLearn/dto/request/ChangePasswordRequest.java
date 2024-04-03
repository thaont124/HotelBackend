package com.g11.LanguageLearn.dto.request;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String oldPassword;

    private String newPassword;
}
