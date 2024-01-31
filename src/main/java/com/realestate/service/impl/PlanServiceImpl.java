package com.realestate.service.impl;

import com.realestate.entity.Plan;
import com.realestate.entity.User;
import com.realestate.repository.PlanRepository;
import com.realestate.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl {
    @Autowired
    private PlanRepository planRepo;
    @Autowired
    private UserRepository userRepo;

    public Plan createPlan(Plan plan) {
        Plan save = planRepo.save(plan);
        return save;

    }

    public HashMap<String, String> purchasePlan(String email, Long id) {
        HashMap<String, String> response = new HashMap<>();
        User user = userRepo.findByEmail(email);
        if (user != null && user.isVerified()) {
            Optional<Plan> plan = planRepo.findById(id);
            user.setPlan_serial_id(plan.get().getSerialId());
            User save = userRepo.save(user);
            response.put("Status", "Successful");
            response.put("Plan", plan.get().getPlanName());

        } else {
            response.put("Status", "Unsuccessful");
        }
        return response;
    }
}
