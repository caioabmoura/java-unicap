package com.example.course.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class LoginResponseEntity {
    private String message;
    private Long id;
}
