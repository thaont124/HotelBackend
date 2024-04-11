package com.g11.LanguageLearn.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreateFeedbackRequest {
    private Integer idBranch;
    private Integer rate;

    private List<MultipartFile> imgFeedback;

    private String content;
}
