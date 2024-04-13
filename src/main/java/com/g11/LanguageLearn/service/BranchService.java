package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.BranchResponse;
import com.g11.LanguageLearn.dto.response.HotelDetailResponse;
import com.g11.LanguageLearn.dto.response.HotelResponse;

import java.util.List;

public interface BranchService {
    List<BranchResponse> getList(Integer idSuggestion);
    HotelDetailResponse getDetailByBranchId(Integer idBranch);
    List<BranchResponse> filterBranchesByUtilities(Integer suggestionId, List<String> utilities);



}
