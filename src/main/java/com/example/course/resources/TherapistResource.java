package com.example.course.resources;

import com.example.course.entities.Therapist;
import com.example.course.services.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/therapist")
public class TherapistResource {

    @Autowired
    TherapistService therapistService;

    @PostMapping
    private ResponseEntity<Therapist> create(@RequestBody Therapist therapist) {
        Therapist t = this.therapistService.create(therapist);
        return ResponseEntity.ok().body(t);
    }

}