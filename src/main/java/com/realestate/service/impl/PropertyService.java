package com.realestate.service.impl;

import com.realestate.entity.Property;


import com.realestate.entity.User;
import com.realestate.repository.PropertyRepository;
import com.realestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.realestate.service.impl.UserServiceImpl.*;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepo;
    @Autowired
    private UserRepository userRepo;

    public Property listProperty(Property property) {
        String user = currentUser.get("user");
        User byEmail = userRepo.findByEmail(user);
        property.setUser_id(byEmail.getId());
        propertyRepo.save(property);
        return property;
}}
