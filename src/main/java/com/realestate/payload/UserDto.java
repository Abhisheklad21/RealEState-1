package com.realestate.payload;


import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    private String name;
    private String mobile;
}
