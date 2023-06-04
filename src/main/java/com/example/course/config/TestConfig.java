package com.example.course.config;

import com.example.course.entities.UserEntity;
import com.example.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity u1 = new UserEntity(null,"caio","caio@123.com","1212312312","1234123");
        UserEntity u2 = new UserEntity(null,"bia","bia@123.com","1212312312","1234123");
        UserEntity u3 = new UserEntity(null,"foli","foli@123.com","1212312312","1234123");
        UserEntity u4 = new UserEntity(null,"let","let@123.com","1212312312","1234123");
        UserEntity u5 = new UserEntity(null,"lu","lu@123.com","1212312312","1234123");
        this.userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));

    }
}
