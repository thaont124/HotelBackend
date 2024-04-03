package com.g11.LanguageLearn.controller;

import com.g11.LanguageLearn.dto.request.ChangeCCCDRequest;
import com.g11.LanguageLearn.dto.request.ChangeEmailRequest;
import com.g11.LanguageLearn.dto.request.ChangePasswordRequest;
import com.g11.LanguageLearn.dto.request.ChangeSDTRequest;
import com.g11.LanguageLearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiv1/")
public class UserController {
    @Autowired
    private UserService userService;

    @PatchMapping("patch/password/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable("id") Integer id, @RequestBody ChangePasswordRequest changePasswordRequest){
        userService.updatePassword(id,changePasswordRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @PatchMapping("/patch/phonenumber/{id}")
    public ResponseEntity<?> updateSDT(@PathVariable("id") Integer id, @RequestBody ChangeSDTRequest changeSDTRequest){
        userService.updateSDT(id, changeSDTRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable("id") Integer id, @RequestBody ChangeEmailRequest changeEmailRequest){
        userService.updateEmail(id, changeEmailRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch/cccd/{id}")
    public ResponseEntity<?> updateCCCD(@PathVariable("id") Integer id, @RequestBody ChangeCCCDRequest changeCCCDRequest){
        userService.updateCCCD(id, changeCCCDRequest );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/point/{id}")
    public ResponseEntity<?> getLastPoint(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getLastPoint(id),HttpStatus.OK);
    }

    @GetMapping("/history/point/{id}")
    public ResponseEntity<?> getHistoryPoint(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getHistoryPoint(id),HttpStatus.OK);
    }

}