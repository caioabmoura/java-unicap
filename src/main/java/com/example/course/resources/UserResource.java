package com.example.course.resources;

import com.example.course.entities.LoginRequestEntity;
import com.example.course.entities.LoginResponseEntity;
import com.example.course.entities.UserEntity;
import com.example.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> list = this.service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id) {
        UserEntity user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity user) {
        UserEntity userEntity = this.service.create(user);
        return ResponseEntity.ok().body(userEntity);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseEntity> create(@RequestBody LoginRequestEntity loginRequestEntity) {
        LoginResponseEntity userId = this.service.login(loginRequestEntity);
        return ResponseEntity.ok().body(userId);
    }
}
