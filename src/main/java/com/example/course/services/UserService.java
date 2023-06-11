package com.example.course.services;

import com.example.course.entities.LoginRequestEntity;
import com.example.course.entities.LoginResponseEntity;
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
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TherapistRepository therapistRepository;
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        return user.get();
    }

    public UserEntity create(UserEntity user){
        UserEntity newUser = new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getPassword());
        this.userRepository.saveAll(Arrays.asList(newUser));
        return newUser;
    }

    public LoginResponseEntity login(LoginRequestEntity loginRequestEntity) {
        List<UserEntity> all = this.userRepository.findAll();

        for (UserEntity entity:all) {
            if (entity.getEmail().equals(loginRequestEntity.getEmail())){
                if(checkPassword(entity.getPassword(),loginRequestEntity.getPassword())){
                    return new LoginResponseEntity(null,entity.getId());
                }
                return new LoginResponseEntity("Invalid Password",null);
            }
        }
        return new LoginResponseEntity("Invalid email",null);
    }

    private boolean checkPassword(String entityPassword, String loginPassword) {
        return entityPassword.equals(loginPassword);
    }

    public UserEntity therapy(Long id, Long therapistId) {
        UserEntity user = this.userRepository.getReferenceById(id);
        Therapist therapist = this.therapistRepository.findById(therapistId).get();
        UserEntity newUser = new UserEntity(user.getId(),user.getName(),user.getEmail(),user.getPhone(),user.getPassword(),therapist);
        return newUser;
    }
}
