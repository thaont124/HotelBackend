package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.AddressResponse;
import com.g11.LanguageLearn.dto.response.HotelDetailResponse;
import com.g11.LanguageLearn.dto.response.HotelResponse;
import com.g11.LanguageLearn.dto.response.PhotoResponse;
import com.g11.LanguageLearn.entity.*;
import com.g11.LanguageLearn.exception.base.BaseException;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.*;
import com.g11.LanguageLearn.service.HotelService;
import com.g11.LanguageLearn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl  implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private SuggestionRepository suggestionRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PhotoBranchRepository photoBranchRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private StorageService storageService;

    public List<HotelResponse> getList(Integer idSuggestion){
        List<Hotel> hotels = hotelRepository.getListBySuggestionID(idSuggestion);
        if(!suggestionRepository.existsById(idSuggestion)){
            throw new BaseException(404, "NOT_FOUND", "No hotel");
        }

        //chuyển đổi sang response trả ra fe
        List<HotelResponse> result = new ArrayList<>();
        for (Hotel hotel : hotels){
            HotelResponse hotelResponse = new HotelResponse();
            hotelResponse.setNameHotel(hotel.getNameHotel());

            result.add(hotelResponse);
        }

        return result;
    }

    @Override
    public HotelDetailResponse getDetailByBranchId(Integer idBranch) {
        Branch branch = branchRepository.findById(idBranch).orElseThrow();
        List<PhotoBranch> photoList = photoBranchRepository.findAll();
        Address address = addressRepository.getAddressByIdBranch(idBranch);

        List<PhotoResponse> photosResponse = new ArrayList<>();
        for (PhotoBranch p : photoList){
            if (p.getBranch().getIdBranch() == idBranch){
                photosResponse.add(new PhotoResponse(p.getType(), storageService.getPhotoURL(p.getUri())));
            }
        }

        HotelDetailResponse hotelResponse = new HotelDetailResponse();
        hotelResponse.setHotelName(branch.getHotel().getNameHotel());
        hotelResponse.setPhoto(photosResponse);
        hotelResponse.setRate(feedbackRepository.getRateByIdBranch(idBranch));
        hotelResponse.setAddress(new AddressResponse(address.getFullAddress(),
                address.getCoordination().getLatitude(), address.getCoordination().getLongitude()));
        return hotelResponse;
    }


}
