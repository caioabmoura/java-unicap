package com.example.course.entities;

import lombok.Data;

@Data
public class LoginRequestEntity {
    private String email;
    private String password;
}
