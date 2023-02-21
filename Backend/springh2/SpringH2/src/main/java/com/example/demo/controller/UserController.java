package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping ("/user/createUser")
    public void createNewUser(@RequestBody User user){
        userServiceImpl.createUser(user);
    }

    @DeleteMapping ("/user/deleteAll")
    public String deleteAll(){
        userServiceImpl.deleteAll();
        return "All Deleted Successfully!!!";
    }

}
