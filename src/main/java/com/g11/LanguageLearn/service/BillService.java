package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.dto.request.BillRequest;
import com.g11.LanguageLearn.dto.response.BillResponse;

public interface BillService {
    public void createBill(BillRequest billRequest);
}
