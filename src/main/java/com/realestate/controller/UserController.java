package com.realestate.controller;


import com.realestate.email.EmailService;
import com.realestate.email.EmailVerificationService;
import com.realestate.payload.UserDto;
import com.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    //http://localhost:8080/api/user/create

    UserService userService;
    @Autowired
    private EmailVerificationService emailVerificationService;
    @Autowired
    EmailService emailService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        UserDto user = userService.createUser(userDto);
        emailService.sendOtpEmail(userDto.getEmail());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    //http://localhost:8080/api/user/verify-user
    @PostMapping("/verify-user")
    public ResponseEntity<?> verifyUser(@RequestParam String email, @RequestParam String otp) {
        HashMap<String, String> response = emailVerificationService.verifyOtp(email, otp);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
