package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.BranchResponse;
import com.g11.LanguageLearn.dto.response.UtilityResponse;

import java.util.List;

public interface UtilityService {
    List<UtilityResponse> getList(Integer idTypeRoom);

}
