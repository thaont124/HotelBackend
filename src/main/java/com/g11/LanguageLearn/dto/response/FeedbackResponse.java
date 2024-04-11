package com.g11.LanguageLearn.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class FeedbackResponse { // doi tuong tra ve frontend
    private Integer idBranch;
    private Integer rate;

    private List<PhotoResponse> imgFeedback;

    private String content;

}
