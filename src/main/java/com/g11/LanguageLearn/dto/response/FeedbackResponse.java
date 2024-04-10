package com.g11.LanguageLearn.dto.response;

import lombok.Data;

@Data
public class FeedbackResponse { // doi tuong tra ve frontend
    private Integer idBranch;
    private Integer rate;

    private String imgFeedback;

    private String content;

}
