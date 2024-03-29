package com.example.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String about;

    @JsonIgnore
    @OneToOne(mappedBy = "therapist")
    private UserEntity userEntity;
    public Therapist(Long id, String name, String email, String phone,String about){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.about = about;
    }
    public Therapist(){}
}
