package com.andrewexe.userExam.services;


import com.andrewexe.userExam.models.Country;
import com.andrewexe.userExam.models.User;
import com.andrewexe.userExam.models.UserDto;
import com.andrewexe.userExam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getFirstName(), user.getAge(), user.getCountry().name()))
                .toList();
    }

    public void addUser(UserDto user){
        if (user.getFirstName() == null) {
            throw new IllegalArgumentException("Invalid user data");
        }
        User usr = new User(null, user.getFirstName(), user.getAge(), Country.valueOf(user.getCountry()));
        userRepository.save(usr);
    }

    public List<UserDto> getUsersByAge(int age){
        return userRepository.getUsersByAge(age).stream().map(
                user -> new UserDto(user.getFirstName(), user.getAge(), user.getCountry().name())
        ).toList();
    }
}
