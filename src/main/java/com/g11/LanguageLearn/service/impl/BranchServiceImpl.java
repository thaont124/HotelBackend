package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.response.*;
import com.g11.LanguageLearn.entity.*;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.*;
import com.g11.LanguageLearn.service.BranchService;
import com.g11.LanguageLearn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private SuggestionRepository suggestionRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private StorageService storageService;

    public List<BranchResponse> getList(Integer idSuggestion){
        List<Branch> branches = branchRepository.getListBySuggestionID(idSuggestion);
        if(!suggestionRepository.existsById(idSuggestion)){
            throw new NotFoundException();
        }

        //chuyển đổi sang response trả ra fe
        List<BranchResponse> result = new ArrayList<>();
        for (Branch branch : branches){
            BranchResponse branchResponse = new BranchResponse();

            branchResponse.setPrice(branch.getPrice());
            branchResponse.setHotelResponse(convertToHotelResponse(branch.getHotel()));
            branchResponse.setAddressResponse(convertToAddressResponse(branch.getAddress()));

            result.add(branchResponse);
        }

        return result;
    }
    public List<BranchResponse> filterBranchesByUtilities(Integer suggestionId, List<String> utilities) {
        Suggestion suggestion = suggestionRepository.findById(suggestionId)
                .orElseThrow(() -> new NotFoundException());
        List<Branch> filteredBranches = branchRepository.findBranchesBySelectedUtilities(suggestion, utilities, utilities.size());
        List<BranchResponse> result = new ArrayList<>();
        for (Branch branch : filteredBranches) {
            BranchResponse branchResponse = new BranchResponse();
            branchResponse.setPrice(branch.getPrice());
            branchResponse.setHotelResponse(convertToHotelResponse(branch.getHotel()));
            branchResponse.setAddressResponse(convertToAddressResponse(branch.getAddress()));
            result.add(branchResponse);
        }
        return result;
    }

    private HotelResponse convertToHotelResponse(Hotel hotel) {
        HotelResponse hotelResponse = new HotelResponse();
        // Sao chép các thuộc tính từ entity Hotel sang DTO HotelResponse
        hotelResponse.setNameHotel(hotel.getNameHotel());

        // ...
        return hotelResponse;
    }

    private AddressResponse convertToAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        // Sao chép các thuộc tính từ entity Address sang DTO AddressResponse
        addressResponse.setAddress(address.getFullAddress());
        addressResponse.setLongitude(address.getCoordination().getLongitude());
        addressResponse.setLatitude(address.getCoordination().getLatitude());
        // ...
        return addressResponse;
    }

    @Override
    public HotelDetailResponse getDetailByBranchId(Integer idBranch) {
        Branch branch = branchRepository.findById(idBranch).orElseThrow();
        List<Photo> photoList = photoRepository.getPhotoByIdHotel(branch.getHotel().getIdHotel());

        List<PhotoResponse> photosResponse = new ArrayList<>();
        for (Photo p : photoList){
            photosResponse.add(new PhotoResponse(p.getType(), storageService.getPhotoURL(p.getUri())));
        }
        HotelDetailResponse hotelResponse = new HotelDetailResponse();
        hotelResponse.setHotelName(branch.getHotel().getNameHotel());
        hotelResponse.setPhoto(photosResponse);
        hotelResponse.setRate(feedbackRepository.getRateByIdBranch(idBranch));
        return hotelResponse;
    }




}
