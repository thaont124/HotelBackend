package com.g11.LanguageLearn.dto.request;

import lombok.Data;

@Data
public class CreateFeedbackRequest {
    private Integer idBranch;
    private Integer rate;

    private String imgFeedback;

    private String content;
}
