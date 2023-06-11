package com.example.course.services;

import com.example.course.entities.Therapist;
import com.example.course.entities.UserEntity;
import com.example.course.repositories.TherapistRepository;
import com.example.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TherapistService {
    @Autowired
    TherapistRepository therapistRepository;

    public Therapist create(Therapist therapist) {
        Therapist t = new Therapist(therapist.getId(), therapist.getName(), therapist.getEmail(), therapist.getPhone());
        this.therapistRepository.saveAll(Arrays.asList(t));
        return t;
    }

    public List<Therapist> getAll() {
        return this.therapistRepository.findAll();
    }

    public Therapist findById(Long id) {
        Optional<Therapist> therapist = this.therapistRepository.findById(id);
        return therapist.get();
    }
}
