package com.g11.LanguageLearn.exception.objectException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private String code;
    private int status;
}
