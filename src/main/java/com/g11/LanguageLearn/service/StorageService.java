package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.entity.PhotoFeedback;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void store(MultipartFile file);

    void deleteAll();
    String formatFileURL(MultipartFile file);

    Path getUniqueDestinationFile(Path destinationFile);

    boolean isVideo(MultipartFile file);

    boolean isImage(MultipartFile file);

    PhotoFeedback savePhotoFeedback(PhotoFeedback photo);
}