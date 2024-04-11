package com.g11.LanguageLearn.controller;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.g11.LanguageLearn.dto.request.LoginRequest;
import com.g11.LanguageLearn.dto.request.RegistrationRequest;
import com.g11.LanguageLearn.dto.response.LoginResponse;
import com.g11.LanguageLearn.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("apiv1/auth")

@Data
@AllArgsConstructor(staticName = "of")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveUser(@RequestBody RegistrationRequest registrationRequest){
        int id = userService.addUser(registrationRequest);
        return new ResponseEntity<>(id, HttpStatus.OK);
   }
//    public int saveUser(@RequestBody RegistrationRequest registrationRequest)
//    {
//        int id = userService.addUser(registrationRequest);
//        return id;
//    }


    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = userService.loginUser(loginRequest);
        return ResponseEntity.ok(loginResponse);
    }
}


