package com.example.course.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.matcher.FilterableList.Empty;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class UserEntity implements Serializable {
    private static final long serialVersionUID =  1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;


    public UserEntity(){}

    public UserEntity(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

}
