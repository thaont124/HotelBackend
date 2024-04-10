package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.request.CreateFeedbackRequest;
import com.g11.LanguageLearn.dto.response.FeedbackResponse;
import com.g11.LanguageLearn.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apiv1/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("getList/{idBranch}")
    public ResponseEntity<?> getList(@PathVariable("idBranch") Integer idBranch){
        List<FeedbackResponse> list = feedbackService.getList(idBranch);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<?> createFeedback(@RequestBody CreateFeedbackRequest request){
        FeedbackResponse response = feedbackService.createFeedback(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
