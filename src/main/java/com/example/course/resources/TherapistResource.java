package com.example.course.resources;

import com.example.course.entities.Therapist;
import com.example.course.entities.UserEntity;
import com.example.course.services.TherapistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    private ResponseEntity<List<Therapist>> getTherapists() {
        List<Therapist> t = this.therapistService.getAll();
        return ResponseEntity.ok().body(t);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Therapist> findById(@PathVariable Long id) {
        Therapist therapist = this.therapistService.findById(id);
        return ResponseEntity.ok().body(therapist);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Therapist> update(@PathVariable Long id,@RequestBody Therapist therapistUpdateEntity){
        Therapist therapist = this.therapistService.update(id, therapistUpdateEntity);
        return ResponseEntity.ok().body(therapist);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.therapistService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}