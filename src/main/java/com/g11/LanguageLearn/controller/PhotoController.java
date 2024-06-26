package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1")
public class PhotoController {
    @Autowired
    private StorageService storageService;
    @GetMapping("/{fileName:.+}")
    public ResponseEntity<?> getPhoto(@PathVariable String fileName) {
        Resource file = storageService.loadAsResource(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // Đổi kiểu MIME tùy thuộc vào loại file
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
