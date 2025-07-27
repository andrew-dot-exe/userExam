package com.andrewexe.userExam.controllers;

import com.andrewexe.userExam.models.User;
import com.andrewexe.userExam.models.UserDto;
import com.andrewexe.userExam.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("user-api/v1/users")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("user-api/v1/users")
    public void addUser( @RequestBody UserDto user){
        userService.addUser(user);
    }

    @GetMapping("user-api/v1/users/additional-info")
    public List<UserDto> getUsersByAge( @RequestParam int age){
        return userService.getUsersByAge(age);
    }
}
