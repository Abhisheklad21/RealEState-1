package com.realestate.controller;


import com.realestate.entity.Property;
import com.realestate.service.impl.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    //http://localhost:8080/api/property/list-property
    @PostMapping("/list-property")
    public ResponseEntity<?> listProperty(@RequestBody Property property){
        Property listedProperty = propertyService.listProperty(property);
        return new ResponseEntity<>("Your Property is listed Succcessfully !!!:" + listedProperty, HttpStatus.CREATED);

    }




}
