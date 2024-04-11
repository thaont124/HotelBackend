package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.HotelDetailResponse;
import com.g11.LanguageLearn.dto.response.HotelResponse;

import java.util.List;

public interface HotelService {
    List<HotelResponse> getList(Integer idSuggestion);
    HotelDetailResponse getDetailByBranchId(Integer idBranch);
}
