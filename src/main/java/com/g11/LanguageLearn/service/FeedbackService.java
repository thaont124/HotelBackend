package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.FeedbackRespone;

import java.util.List;

public interface FeedbackService {

    List<FeedbackRespone> getList(Integer idHotel);
}
