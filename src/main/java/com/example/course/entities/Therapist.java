package com.example.course.entities;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "therapist")
public class Therapist implements Serializable {
    private static final long serialVersionUID =  1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @OneToOne
    private UserEntity userEntity;
    public Therapist(Long id, String name, String email, String phone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
