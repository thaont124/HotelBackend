package com.g11.LanguageLearn.service.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import com.g11.LanguageLearn.entity.PhotoFeedback;
import com.g11.LanguageLearn.exception.base.BaseException;
import com.g11.LanguageLearn.property.StorageProperties;
import com.g11.LanguageLearn.repository.PhotoFeedbackRepository;
import com.g11.LanguageLearn.repository.PhotoHotelRepository;
import com.g11.LanguageLearn.repository.PhotoRoomRepository;
import com.g11.LanguageLearn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;

//video
import org.apache.tika.Tika;

@Service
public class StorageServiceImpl implements StorageService {

    private final Path rootLocation;
    @Autowired
    private PhotoFeedbackRepository photoFeedbackRepository;
    @Autowired
    private PhotoHotelRepository photoHotelRepository;
    @Autowired
    private PhotoRoomRepository photoRoomRepository;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {

        if(properties.getLocation().trim().length() == 0){
            throw new BaseException(500, "INTERNAL_SERVER_ERROR", "File upload location can not be Empty.");
        }

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new BaseException(500, "INTERNAL_SERVER_ERROR", "Failed to store empty file.");
            }

            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();

            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new BaseException(500, "INTERNAL_SERVER_ERROR",
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Path uniqueDestinationFile = getUniqueDestinationFile(destinationFile);
                Files.copy(inputStream, uniqueDestinationFile,
                        StandardCopyOption.REPLACE_EXISTING);

            }
        } catch (IOException e) {
            throw new BaseException(500, "INTERNAL_SERVER_ERROR", "Failed to store file.\n" + e);
        }

    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new BaseException(500, "INTERNAL_SERVER_ERROR", "Could not initialize storage:\n " + e.getMessage());
        }
    }

    public String formatFileURL(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new BaseException(500, "INTERNAL_SERVER_ERROR", "Failed to store empty file.");
            }

            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Path uniqueDestinationFile = getUniqueDestinationFile(destinationFile);
                String filename = uniqueDestinationFile.getFileName().toString();
                String baseName = FilenameUtils.getBaseName(filename);
                String extension = FilenameUtils.getExtension(filename);

                return baseName + "." + extension;
            }
        } catch (IOException e) {
            throw new BaseException(500, "INTERNAL_SERVER_ERROR", "Failed to format fileURL.\n" + e);
        }
    }
    public Path getUniqueDestinationFile(Path destinationFile) {
        Path uniquePath = destinationFile;
        int count = 1;
        while (Files.exists(uniquePath)) {
            String filename = destinationFile.getFileName().toString();
            String baseName = FilenameUtils.getBaseName(filename);
            String extension = FilenameUtils.getExtension(filename);

            String uniqueFilename = baseName + "(" + count + ")." + extension;
            uniquePath = destinationFile.resolveSibling(uniqueFilename);
            count++;
        }
        return uniquePath;
    }
    public boolean isVideo(MultipartFile file) {
        Tika tika = new Tika();

        try {
            String mimeType = tika.detect(file.getInputStream());

            // Check if the MIME type is a video type
            return mimeType != null && mimeType.startsWith("video/");
        } catch (IOException e) {
            return false;
        }
    }

    public boolean isImage(MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {

            // Đọc dữ liệu hình ảnh và video từ InputStream
            BufferedImage image = ImageIO.read(inputStream);
            if (image == null) {
                return false;
            }
            // Kiểm tra xem image có chứa dữ liệu hợp lệ hay không
            // Trong trường hợp này, chúng ta chỉ muốn đảm bảo rằng image/video không rỗng
            return image.getWidth() > 0 && image.getHeight() > 0;
        }
        catch (IOException e) {
            return false;
        }
    }

    @Override
    public PhotoFeedback savePhotoFeedback(PhotoFeedback photo) {
        PhotoFeedback savedPhoto = photoFeedbackRepository.save(photo);
        return savedPhoto;
    }
}