package com.realestate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Property {
    @Id
    private int id;
    private String propertyName;
    private String location;
    private String area;
    private String price;
    private String type;
    private String description;
    private long user_id;

}
