package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.request.SettingUpdateRequest;
import com.g11.LanguageLearn.entity.NotificationSetting;
import com.g11.LanguageLearn.service.NotificationService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apiv1/setting")
public class SettingController {
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/{idUser}")
    public ResponseEntity<?> getSetting(@PathVariable("idUser") Integer idUser){
        return new ResponseEntity<>(notificationService.getSetting(idUser), HttpStatus.OK);
    }

    @PutMapping("{idUser}")
    public ResponseEntity<?> updateSetting(@PathVariable("idUser") Integer idUser, @RequestBody SettingUpdateRequest request){
        return new ResponseEntity<>(notificationService.updateSetting(idUser, request), HttpStatus.OK);
    }
}
