package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.response.BranchResponse;
import com.g11.LanguageLearn.dto.response.HotelResponse;
import com.g11.LanguageLearn.service.BranchService;

import com.g11.LanguageLearn.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("apiv1/hotel")
public class BranchController {
    @Autowired
    private BranchService branchService;
    @Autowired
    private AddressService addressService;

    @GetMapping("getList/{idSuggestion}")
    public ResponseEntity<?> getList(@PathVariable("idSuggestion") Integer idSuggestion){
        List<BranchResponse> list = branchService.getList(idSuggestion);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("filterBranchesByUtilities")
    public ResponseEntity<?> filterBranchesByUtilities(@RequestParam("suggestionId") Integer suggestionId, @RequestBody List<String> utilities) {
        List<BranchResponse> filteredBranches = branchService.filterBranchesByUtilities(suggestionId, utilities);
        return new ResponseEntity<>(filteredBranches, HttpStatus.OK);
    }
    @GetMapping("address/{idBranch}")
    public ResponseEntity<?> getAddressByBranchId(@PathVariable("idBranch") Integer idBranch){
        return new ResponseEntity<>(addressService.getAddressByIdBranch(idBranch), HttpStatus.OK);
    }



    @GetMapping("/detail/{idBranch}")
    public ResponseEntity<?> getDetailByBranchId(@PathVariable("idBranch") Integer idBranch){
        return new ResponseEntity<>(branchService.getDetailByBranchId(idBranch), HttpStatus.OK);
    }
}
