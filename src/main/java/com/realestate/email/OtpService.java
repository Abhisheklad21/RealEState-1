package com.realestate.email;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

    public String generateOtp() {
        return String.format("%06d", new java.util.Random().nextInt(1000000));
    }
}

