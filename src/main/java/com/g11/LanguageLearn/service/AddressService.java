package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.response.AddressResponse;

public interface AddressService {
    AddressResponse getAddressByIdBranch(Integer idBranch);
}
