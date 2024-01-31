package com.realestate.controller;


import com.realestate.entity.Plan;
import com.realestate.service.impl.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private PlanServiceImpl planService;

    //http://localhost:8080/api/plan/create
    @PostMapping("/create")
    public ResponseEntity<?> createPlan(@RequestBody Plan plan){
        Plan savedPlan = planService.createPlan(plan);
       return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/plan/purchase
    @PostMapping("/purchase")
    public ResponseEntity<?> purchasePlan(@RequestParam String email, @RequestParam Long id){
        HashMap<String, String> purchased = planService.purchasePlan(email, id);
        return new ResponseEntity<>(purchased,HttpStatus.OK);
    }

}
