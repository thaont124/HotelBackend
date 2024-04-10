package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.CreateFeedbackRequest;
import com.g11.LanguageLearn.dto.response.FeedbackResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FeedbackService {

    List<FeedbackResponse> getList(Integer idBranch);
    FeedbackResponse createFeedback(CreateFeedbackRequest request);
}
