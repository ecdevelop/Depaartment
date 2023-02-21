package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void createUser(User user);

    void deleteAll();


}
