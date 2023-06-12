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
        Therapist t = new Therapist(therapist.getId(), therapist.getName(), therapist.getEmail(), therapist.getPhone(),therapist.getAbout());
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

    public void delete(Long id) {
        Therapist therapist = this.therapistRepository.findById(id).get();

        this.therapistRepository.delete(therapist);
    }

    public Therapist update(Long id, Therapist therapistUpdateEntity) {
        Optional<Therapist> therapist = this.therapistRepository.findById(id);


        if(therapist.isEmpty()){
            return null;
        }
        Therapist therapistFound = therapist.get();
        if(therapistUpdateEntity.getName() != null){
            if (!therapistUpdateEntity.getName().isBlank()){
                therapistFound.setName(therapistUpdateEntity.getName());
            }
        }
        if(therapistUpdateEntity.getAbout() != null){
            if (!therapistUpdateEntity.getAbout().isBlank()){
                therapistFound.setAbout(therapistUpdateEntity.getAbout());
            }
        }
        if(therapistUpdateEntity.getEmail() != null){
            if (!therapistUpdateEntity.getEmail().isBlank()){
                therapistFound.setEmail(therapistUpdateEntity.getEmail());
            }
        }
        if(therapistUpdateEntity.getPhone() != null){
            if (!therapistUpdateEntity.getPhone().isBlank()){
                therapistFound.setPhone(therapistUpdateEntity.getPhone());
            }
        }
        this.therapistRepository.save(therapistFound);
        return therapistFound;
    }
}
