package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiv1/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @GetMapping("/list/{idUser}")
    public ResponseEntity<?> getAllList(@PathVariable("idUser") Integer idUser){
        return new ResponseEntity<>(notificationService.getAllNoticationByUser(idUser), HttpStatus.OK);
    }

    @GetMapping("/detail/{idNotification}")
    public ResponseEntity<?> getDetail(@PathVariable("idNotification") Integer idNotification){
        return new ResponseEntity<>(notificationService.getDetailBill(idNotification), HttpStatus.OK);
    }
}
