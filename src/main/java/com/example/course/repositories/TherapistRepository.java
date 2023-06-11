package com.example.course.repositories;

import com.example.course.entities.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapistRepository extends JpaRepository<Therapist,Long> {
}
