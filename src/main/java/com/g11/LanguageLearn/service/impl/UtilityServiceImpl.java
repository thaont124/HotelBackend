package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.UtilityResponse;
import com.g11.LanguageLearn.entity.Utility;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.TypeRoomRepository;
import com.g11.LanguageLearn.repository.UtilityRepository;
import com.g11.LanguageLearn.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilityServiceImpl implements UtilityService {
    @Autowired //tiêm interface repo
    private UtilityRepository utilityRepository;
    @Autowired
    private TypeRoomRepository typeRoomRepository;

    public List<UtilityResponse> getList(Integer idTypeRoom){
        List<Utility> utilities = utilityRepository.getListByTypeRoomID(idTypeRoom);
        if(!typeRoomRepository.existsById(idTypeRoom)){
            throw new NotFoundException();
        }

        //chuyển đổi sang response trả ra fe
        List<UtilityResponse> result = new ArrayList<>();
        for (Utility utility : utilities){
            UtilityResponse utilityResponse = new UtilityResponse();
            utilityResponse.setName(utility.getNameUtility());

            result.add(utilityResponse);
        }

        return result;
    }

    @Override
    public List<UtilityResponse> getAllUtilities() {
        List<Utility> utilities = utilityRepository.findAll();
        List<UtilityResponse> responses = new ArrayList<>();
        for (Utility utility : utilities) {
            UtilityResponse response = new UtilityResponse();
            response.setName(utility.getNameUtility());
            responses.add(response);
        }
        return responses;
    }
}
