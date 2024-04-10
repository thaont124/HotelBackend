package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.CreateFeedbackRequest;
import com.g11.LanguageLearn.dto.response.FeedbackResponse;
import com.g11.LanguageLearn.entity.Feedback;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.BranchRepository;
import com.g11.LanguageLearn.repository.FeedbackRepository;
import com.g11.LanguageLearn.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired //tiêm interface repo
    private FeedbackRepository feedbackRepository;
    @Autowired
    private BranchRepository branchRepository;

    public List<FeedbackResponse> getList(Integer idBranch){
        List<Feedback> feedbacks = feedbackRepository.getListByBranchID(idBranch);
        if(!branchRepository.existsById(idBranch)){
            throw new NotFoundException();
        }

        //chuyển đổi sang response trả ra fe
        List<FeedbackResponse> result = new ArrayList<>();
        for (Feedback feedback : feedbacks){
            FeedbackResponse feedbackRespone = new FeedbackResponse();

            feedbackRespone.setRate(feedback.getRate());
            feedbackRespone.setImgFeedback(feedback.getImgFeedback());
            feedbackRespone.setContent(feedback.getContent());

            result.add(feedbackRespone);
        }

        return result;
    }

    @Override
    public FeedbackResponse createFeedback(CreateFeedbackRequest request) {
        // Kiểm tra xem branch có tồn tại không
        if(!branchRepository.existsById(request.getIdBranch())){
            throw new NotFoundException();
        }

        // Tạo mới một đối tượng Feedback từ request
        Feedback feedback = new Feedback();
        feedback.setRate(request.getRate());
        feedback.setImgFeedback(request.getImgFeedback());
        feedback.setContent(request.getContent());

        // Lưu đối tượng Feedback vào cơ sở dữ liệu
        Feedback savedFeedback = feedbackRepository.save(feedback);

        // Chuyển đổi đối tượng Feedback đã lưu thành FeedbackResponse
        FeedbackResponse response = new FeedbackResponse();
        response.setRate(savedFeedback.getRate());
        response.setImgFeedback(savedFeedback.getImgFeedback());
        response.setContent(savedFeedback.getContent());

        return response;
    }
}
