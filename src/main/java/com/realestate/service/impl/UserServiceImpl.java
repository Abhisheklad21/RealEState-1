package com.realestate.service.impl;

import com.realestate.email.EmailService;
import com.realestate.entity.User;
import com.realestate.payload.UserDto;
import com.realestate.repository.UserRepository;
import com.realestate.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private EmailService emailService;
//    @Autowired
//    private HttpSession session;
    public static final Map<String, String> currentUser = new HashMap<>();

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
//        User userByEmail = userRepo.findByEmail(user.getEmail());
//        Boolean verified = userRepo.isVerified(user.getEmail());
        User save = userRepo.save(user);
        UserDto userDto1 = mapToDto(save);
        return userDto1;
    }


    public void verifyEmail(String email) {
        User user = userRepo.findByEmail(email);
        System.out.println(user.getName());
        user.setVerified(true);
        System.out.println(user.isVerified());
        User save = userRepo.save(user);
        System.out.println(save);
    }


    @Override
    public HashMap<String, String> loginUser(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);
        System.out.println("login");
        HashMap<String, String> response = new HashMap<>();
        if (user != null) {
            response.put("Status", "Login Success !!");
            currentUser.put("user", email);

        } else {
            response.put("Status", "Incorrect Email or Password !!!");
        }
        return response;
    }


    UserDto mapToDto(User user) {
        UserDto mapDto = modelMapper.map(user, UserDto.class);
        return mapDto;
    }

    User mapToEntity(UserDto userDto) {
        User mapEntity = modelMapper.map(userDto, User.class);
        return mapEntity;
    }
}
