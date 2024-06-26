package com.g11.LanguageLearn.service;

import com.g11.LanguageLearn.entity.PhotoBranch;
import com.g11.LanguageLearn.entity.PhotoFeedback;
import com.g11.LanguageLearn.entity.PhotoRoom;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    Path load(String filename);

    void store(MultipartFile file);

    void deleteAll();
    String formatFileURL(MultipartFile file);

    Path getUniqueDestinationFile(Path destinationFile);

    boolean isVideo(MultipartFile file);

    boolean isImage(MultipartFile file);

    PhotoRoom savePhotoRoom(PhotoRoom photo);

    PhotoFeedback savePhotoFeedback(PhotoFeedback photo);

    PhotoBranch savePhotoHotel(PhotoBranch photo);

    String getPhotoURL(String fileName);


    Resource loadAsResource(String filename);
}