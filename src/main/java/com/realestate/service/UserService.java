package com.realestate.service;

import com.realestate.payload.UserDto;

import java.util.HashMap;
import java.util.Map;

public interface UserService {
    UserDto createUser(UserDto userDto);

    void verifyEmail(String email);

    HashMap<String, String> loginUser(String email, String password);

//    Map<String, String> loginUser(String , String );
}
