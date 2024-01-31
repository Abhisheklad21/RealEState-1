package com.realestate.email;

import com.realestate.repository.UserRepository;
import com.realestate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.realestate.email.EmailService.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailVerificationService {

    @Autowired
    private UserService userService;

    public HashMap<String, String> verifyOtp(String email, String otp) {
        Map<String, String> response = new HashMap<String, String>();
        String storedOtp = emailOtpMapping.get(email);
        if (storedOtp!=null && storedOtp.equals(otp)) {
            response.put("Status", "Success");
            response.put("Message", "OTP Verified Successfully !!");
            userService.verifyEmail(email);
            emailOtpMapping.remove(email);
        } else {
            response.put("Status", "Error");
            response.put("Message", "Invalid OTP !!!");
        }

        return (HashMap<String, String>) response;

    }
}
