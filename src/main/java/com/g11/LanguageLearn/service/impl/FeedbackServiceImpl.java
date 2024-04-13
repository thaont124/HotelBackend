package com.g11.LanguageLearn.service.impl;

import com.g11.LanguageLearn.dto.request.CreateFeedbackRequest;
import com.g11.LanguageLearn.dto.response.FeedbackResponse;
import com.g11.LanguageLearn.dto.response.PhotoResponse;
import com.g11.LanguageLearn.entity.Feedback;
import com.g11.LanguageLearn.entity.Photo;
import com.g11.LanguageLearn.entity.PhotoFeedback;
import com.g11.LanguageLearn.entity.PhotoBranch;
import com.g11.LanguageLearn.exception.base.BaseException;
import com.g11.LanguageLearn.exception.base.NotFoundException;
import com.g11.LanguageLearn.repository.BranchRepository;
import com.g11.LanguageLearn.repository.FeedbackRepository;
import com.g11.LanguageLearn.service.FeedbackService;
import com.g11.LanguageLearn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired //tiêm interface repo
    private FeedbackRepository feedbackRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private StorageService storageService;

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
//            feedbackRespone.setImgFeedback(feedback.getImgFeedback());
            feedbackRespone.setContent(feedback.getContent());

            result.add(feedbackRespone);
        }

        return result;
    }

    @Override
    public FeedbackResponse createFeedback(CreateFeedbackRequest request) {
        //Tao returnObject
        FeedbackResponse response = new FeedbackResponse();
        List<PhotoResponse> photoResponse = new ArrayList<>();

        // Kiểm tra xem branch có tồn tại không
        if(!branchRepository.existsById(request.getIdBranch())){
            throw new NotFoundException();
        }

        boolean hasInvalidFile = false; // Biến để kiểm tra xem có file không hợp lệ hay không

        //Lưu ảnh, video
        for (MultipartFile file : request.getImgFeedback()) {
            String type = null;
            if (!storageService.isImage(file) && !storageService.isVideo(file)) {
                hasInvalidFile = true;
                break; // Dừng vòng lặp nếu có file không hợp lệ
            } else if (storageService.isVideo(file)) {
                type = "video";
            } else if (storageService.isImage(file)) {
                type = "image";
            }
        }

        if (!hasInvalidFile) { // Kiểm tra xem có file không hợp lệ không
            // Lưu đối tượng Feedback vào cơ sở dữ liệu
            Feedback feedback = new Feedback();
            feedback.setBranch(branchRepository.findById(request.getIdBranch()).orElseThrow());
            feedback.setRate(request.getRate());
            feedback.setContent(request.getContent());
            Feedback savedFeedback = feedbackRepository.save(feedback);

            for (MultipartFile file : request.getImgFeedback()) {
                String type = null;
                if (storageService.isVideo(file)) {
                    type = "video";
                } else if (storageService.isImage(file)) {
                    type = "image";
                }
                // Lưu file vào storage
                storageService.store(file);
                // Tạo đối tượng PhotoFeedback và lưu vào cơ sở dữ liệu
                PhotoFeedback photo = new PhotoFeedback(storageService.formatFileURL(file), type, savedFeedback);
                PhotoFeedback savedPhoto = storageService.savePhotoFeedback(photo);
                photoResponse.add(new PhotoResponse(savedPhoto.getType(), savedPhoto.getUri()));
            }

            //set returnObject
            response.setRate(savedFeedback.getRate());
            response.setContent(savedFeedback.getContent());
            response.setImgFeedback(photoResponse);
        } else {
            throw new BaseException(500, "INTERNAL_SERVER_ERROR", "There is an image that is incorrect format (only .jpg, .png, vv)");
        }

        // Chuyển đổi đối tượng Feedback đã lưu thành FeedbackResponse



        return response;
    }
}
