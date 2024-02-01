package com.realestate.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plan {

    @Id
    private String id;
    private String planName;
    private long planValidity;
    private String type;
    private long price;

    @OneToMany(mappedBy = "plan")
    private List<User> users = new ArrayList<>();
}
