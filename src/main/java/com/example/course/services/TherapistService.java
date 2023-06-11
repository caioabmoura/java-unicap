package com.example.course.services;

import com.example.course.entities.Therapist;
import com.example.course.repositories.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TherapistService {
    @Autowired
    TherapistRepository therapistRepository;

    public Therapist create(Therapist therapist) {
        Therapist t = new Therapist(therapist.getId(), therapist.getName(), therapist.getEmail(), therapist.getPhone());

        this.therapistRepository.saveAll(Arrays.asList(t));
        return t;
    }
}
