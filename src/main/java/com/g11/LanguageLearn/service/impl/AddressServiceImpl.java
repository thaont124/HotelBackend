package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.AddressResponse;
import com.g11.LanguageLearn.entity.Address;
import com.g11.LanguageLearn.exception.base.BaseException;
import com.g11.LanguageLearn.repository.AddressRepository;
import com.g11.LanguageLearn.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public AddressResponse getAddressByIdBranch(Integer idBranch) {
        Address address = addressRepository.getAddressByIdBranch(idBranch);
        if (address == null){
            throw new BaseException(404, "NOT_FOUND", "Branch not found");
        }

        AddressResponse addressResponse = new AddressResponse(address.getFullAddress(),
                address.getCoordination().getLatitude(), address.getCoordination().getLongitude());

        return addressResponse;
    }
}
