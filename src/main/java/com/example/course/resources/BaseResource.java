package com.example.course.resources;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class BaseResource {

    @GetMapping
    private String base(){
        return "PROJETO JAVA";
    }
}
